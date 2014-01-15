package com.teamo.ejournal.core;

import java.net.URLDecoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

import javax.validation.Valid;

import org.hibernate.mapping.Set;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamo.ejournal.core.model.DownloadableArticles;
import com.teamo.ejournal.core.model.NewReviewer;
import com.teamo.ejournal.core.model.ServerResponse;
import com.teamo.ejournal.orm.UserEntity;
import com.teamo.ejournal.service.ArticleServiceImpl;
import com.teamo.ejournal.service.AuthorServiceImpl;
import com.teamo.ejournal.service.EditorServiceImpl;
import com.teamo.ejournal.service.ReaderServiceImpl;
import com.teamo.ejournal.service.ReviewerServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	@Autowired
	private ReaderServiceImpl readerService;
	
	@Autowired
	private ReviewerServiceImpl reviewerService;
	
	@Autowired
	private EditorServiceImpl editorService;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("journalSettings", editorService.getCurrentJournalSetting());
		
		return "index";
	}
	
	@RequestMapping(value = "/loadContent", method = RequestMethod.GET)
	public String loadContent(@RequestParam String cname, Model model) {
		
		logger.info("Loading content, cname: "+cname);
		
		model.addAttribute("journalSettings", editorService.getCurrentJournalSetting());
		
		//special contents added to .jsp:
		if (cname.equals("browse")){
			model.addAttribute("listArticles", readerService.displayAllArticlesForReader());
		} else if (cname.equals("academic-goals")){
			model.addAttribute("journal", editorService.getCurrentJournal());
		}
		
		//security filter. so, can't inject 'author/home'
		if (cname.indexOf("/") >= 0){
			return "index";
		}
		
		return cname;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchContent(@RequestParam(required=false) String txtToSearch,@RequestParam(required=false) String radio,
			@RequestParam(required=false) String dateStart,@RequestParam(required=false) String dateEnd, Model model) {
		
		logger.info("Searching content: "+txtToSearch+" with method "+radio);
		
		if(dateStart == null || dateStart.isEmpty()){
			if (radio == null) return "index";
			if (radio.equals("title")){
				model.addAttribute("listArticles", readerService.searchArticlesByTitle(txtToSearch));
			} else if (radio.equals("author")){
				model.addAttribute("listArticles", readerService.searchArticlesByAuthor(txtToSearch));
			}else if (radio.equals("keyword")){
				model.addAttribute("listArticles", readerService.searchArticlesByKeyword(txtToSearch));
			}
		} else {
			try {
				DateTimeFormatter formatterOrig = DateTimeFormat.forPattern("MM/dd/yyyy");
				DateTimeFormatter formatterDest = DateTimeFormat.forPattern("yyyy-MM-dd");
				DateTime dtStart = formatterOrig.parseDateTime(dateStart);
				DateTime dtEnd = formatterOrig.parseDateTime(dateEnd);
				logger.info("datestart joda: "+formatterDest.print(dtStart)+" ; end: "+formatterDest.print(dtEnd));
				model.addAttribute("listArticles", readerService.searchArticlesByTimeInterval(formatterDest.print(dtStart), formatterDest.print(dtEnd)));	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return "browse";
	}
	
	@RequestMapping(value = "/register_reviewer", method = RequestMethod.POST)
	public @ResponseBody ServerResponse registerReviewer(@Valid @RequestBody NewReviewer newReviewer,BindingResult result) {
		//pay attention: dont name like 'newRev' an object NewReviewer, bcz the bind will fail. name it 'newReviewer', otherwise specify in the requestbody annotation
		logger.info("add new reviewer: "+ newReviewer);
		
		ServerResponse sr = new ServerResponse();
		if (sr.bindErrors(result)) return sr;
		
		UserEntity user = new UserEntity();
		user.setUsername(newReviewer.getUsername());
		user.setPassword(newReviewer.getPassword());
		try{
			reviewerService.registerNewReviewer(user);
		}catch(Exception ex){
			logger.info("error registering user with username: "+user.getUsername());
			sr.setResponse("fail");
			sr.getArgs().add("Could not register new user.");
			return sr;
		}
		
		sr.setResponse("ok");
		
		return sr;
	}
	
	/*
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test111(Locale locale, Model model) {
		logger.info("Welcome test1");
		
		model.addAttribute("userEntity", new UserEntity());
		
		return "test1";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public @ResponseBody String test222(Locale locale, Model model) {
		logger.info("test2222222");
		
		
		return "fail";
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String testeste1() {
 
		HashSet<Integer> sett = new HashSet<Integer>();
		sett.add(1);
		sett.add(2);
		reviewerService.downloadArticleToReview("geo", sett);
		
		return "index";
	}
	*/
	
}
