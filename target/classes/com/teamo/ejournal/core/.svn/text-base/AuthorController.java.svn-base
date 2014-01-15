package com.teamo.ejournal.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.teamo.ejournal.core.login.AuthenticatedUser;
import com.teamo.ejournal.core.model.AuthorComment;
import com.teamo.ejournal.core.model.ServerResponse;
import com.teamo.ejournal.core.util.UploadUtils;
import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.UserEntity;
import com.teamo.ejournal.service.ArticleServiceImpl;
import com.teamo.ejournal.service.AuthorServiceImpl;
import com.teamo.ejournal.service.EditorServiceImpl;
import com.teamo.ejournal.service.UserServiceImpl;

@Controller
public class AuthorController {

	private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	private AuthorServiceImpl authorService;
	
	@Autowired
	private ArticleServiceImpl articleService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private EditorServiceImpl editorService;
	
	@RequestMapping(value="/author/{authorName}",method = RequestMethod.GET)
	@PreAuthorize("(hasAnyRole('ROLE_ADMIN','ROLE_AUTHOR')) && (hasPermission(#authorName,'sameID'))")
	public String home(@PathVariable String authorName,Model model){
		logger.info("author home for "+authorName);
		
		//it's already added to the model.
		//model.addAttribute("authorName", authorName);
		model.addAttribute("journalSettings", editorService.getCurrentJournalSetting());
		
		return "author/index";
	}
	
	@RequestMapping(value = "/author/{authorName}/loadContent", method = RequestMethod.GET)
	@PreAuthorize("(hasAnyRole('ROLE_ADMIN','ROLE_AUTHOR')) && (hasPermission(#authorName,'sameID'))")
	public String loadContent(@RequestParam String cname,@PathVariable String authorName,Model model,Principal principal){
		
		logger.info("authorname: "+ authorName);
		logger.info("Loading content, cname: "+cname);
		
		model.addAttribute("journalSettings", editorService.getCurrentJournalSetting());
		
		//special contents added to .jsp:
		if (cname.equals("status")){
			model.addAttribute("listArticles", authorService.displayAllArticlesForAuthor(principal.getName()));
		}
		
		return "author/" + cname;
	}
	
	@RequestMapping(value = "/address_review", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_AUTHOR')")
	public @ResponseBody ServerResponse addressReview(@Valid @RequestBody AuthorComment comment,BindingResult result,Principal principal,HttpSession session,HttpServletRequest request){
		
		logger.info("author comment: "+ comment);
		
		ServerResponse sr = new ServerResponse();
		if (sr.bindErrors(result)) return sr;
		
		
		/////TEMP FILE RENAME
		//load original filename from session and delete it from session:
		String origFilename = (String) session.getAttribute(ArticleUploadController.UPLOAD_NAME);
		session.removeAttribute(ArticleUploadController.UPLOAD_NAME);
		String fileURLPath;
		UserEntity user = userService.getUser(principal.getName());
		Article article = articleService.getArticle(comment.getArticleId());
    	//save file
		try{
			logger.info("Calling uploadutils...");
			//how to put on .jsp: response.sendRedirect(request.getContextPath() + "/seja/izpisknjig.jsp");
			int nextVersion = articleService.getNextVersionNumber(article);
	    	String serverSavePath = UploadUtils.getServerSavingPathForUser(
			    				user,
			    				request.getServletContext().getRealPath("/"), 
			    				origFilename, 
			    				String.valueOf(nextVersion));
	    	try {
	    		fileURLPath = UploadUtils.getURLforFile(
	    				user, 
	    				origFilename, 
	    				String.valueOf(nextVersion));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				sr.setResponse("fail");
				sr.getArgs().add("Invalid filename, can't be encoded");
				return sr;
			}
			
			UploadUtils.moveTempFileToPath(request.getServletContext().getRealPath("/"), serverSavePath);
			//UploadUtils.saveFile(articleFile.getFileData(),serverSavePath);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			sr.setResponse("fail");
			sr.getArgs().add("Couldn't save file");
			return sr;
        } catch (IOException e) {
            e.printStackTrace();
            sr.setResponse("fail");
            sr.getArgs().add("Couldn't save file");
            return sr;
        }
		//////////////END TEMP FILE RENAME
		
		try {
			//need to add service to add new author response to review comment
			//authorService.
		} catch (Exception e) {
			sr.setResponse("fail");
			sr.getArgs().add("Couldn't save author comment");
			return sr;
		}
		
		logger.info("Author response saved.");
		
		sr.setResponse("ok");
		return sr;
	}
	
	/*
	@RequestMapping(value = "/article/{articleid}", method = RequestMethod.GET)
	public String viewArticle(@PathVariable String authorName, @PathVariable String articleid, Model model){
		logger.info("author article for "+articleid);
		
		String articleName = "About%20Downloads.pdf";
		
		return "redirect:/resources/"+authorName+"/"+articleName;
	}
	
	@RequestMapping(value = "/article/{articleid}", method = RequestMethod.DELETE)
	public String delete(){
		logger.info("deleted article");
		
		return "author/home";
	}
	*/
}
