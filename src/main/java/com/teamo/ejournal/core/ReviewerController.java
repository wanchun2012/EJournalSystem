package com.teamo.ejournal.core;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamo.ejournal.core.model.DownloadableArticles;
import com.teamo.ejournal.core.model.ReviewForm;
import com.teamo.ejournal.core.model.ServerResponse;
import com.teamo.ejournal.service.EditorServiceImpl;
import com.teamo.ejournal.service.ReviewerServiceImpl;
import com.teamo.ejournal.service.UserServiceImpl;

@Controller
public class ReviewerController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewerController.class);
	
	@Autowired
	private ReviewerServiceImpl reviewerService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private EditorServiceImpl editorService;
	
	@RequestMapping(value="/reviewer/{reviewerName}",method=RequestMethod.GET)
	@PreAuthorize("(hasAnyRole('ROLE_ADMIN','ROLE_REVIEWER')) && (hasPermission(#reviewerName,'sameID'))")
	public String home(@PathVariable String reviewerName,Model model){
		logger.info("reviewer home for "+reviewerName);
		
		model.addAttribute("journalSettings", editorService.getCurrentJournalSetting());
		
		return "reviewer/index";
	}
	
	@RequestMapping(value = "/reviewer/{reviewerName}/loadContent", method = RequestMethod.GET)
	@PreAuthorize("(hasAnyRole('ROLE_ADMIN','ROLE_REVIEWER')) && (hasPermission(#reviewerName,'sameID'))")
	public String loadContent(@RequestParam String cname,@PathVariable String reviewerName, Model model,Principal principal) {
		
		logger.info("reviewername: "+ reviewerName);
		logger.info("Loading content, cname: "+cname);
		
		model.addAttribute("journalSettings", editorService.getCurrentJournalSetting());
		
		//special contents added to .jsp:
		if (cname.equals("status")){
			model.addAttribute("listArticles", reviewerService.displayDownloadedArticleForReviewer(principal.getName()));
		} else if (cname.equals("review")){
			model.addAttribute("listArticles", reviewerService.displayArticleForReviewer(principal.getName(), 20));
			model.addAttribute("user", userService.getUser(principal.getName()));
		}
		
		return "reviewer/" + cname;
	}
	
	@RequestMapping(value = "/download_reviews", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_REVIEWER')")
	public @ResponseBody ServerResponse submitReview(@RequestBody DownloadableArticles downArts,Principal principal) {
		
		logger.info("download article ids: "+ downArts);
		
		ServerResponse sr = new ServerResponse();
		
		try {
			reviewerService.downloadArticleToReview(principal.getName(), downArts.getArticleIds());	
		} catch (Exception e) {
			sr.setResponse("fail");
			sr.getArgs().add("Couldn't set up downloadable articles.");
			sr.getArgs().add("Exception: " +e);
			return sr;
		}
		
		sr.setResponse("ok");
		return sr;
	}

	@RequestMapping(value = "/submit_review", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_REVIEWER')")
	public @ResponseBody ServerResponse submitReview(@Valid @RequestBody ReviewForm reviewForm,BindingResult result,Principal principal) {
		
		logger.info("review form post: "+ reviewForm);
		
		ServerResponse sr = new ServerResponse();
		if (sr.bindErrors(result)) return sr;
		try {
			reviewerService.submitInitArticleReview(principal.getName(), reviewForm);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("failed saving review");
			sr.setResponse("fail");
			sr.getArgs().add("Couldn't save review.");
			return sr;
		}
		
		
		logger.info("Review saved.");
		
		sr.setResponse("ok");
		return sr;
	}
	
	
}
