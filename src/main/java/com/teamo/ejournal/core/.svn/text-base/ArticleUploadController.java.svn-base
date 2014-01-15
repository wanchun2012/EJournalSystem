package com.teamo.ejournal.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.teamo.ejournal.core.model.ArticleUpload;
import com.teamo.ejournal.core.model.Author;
import com.teamo.ejournal.core.model.ServerResponse;
import com.teamo.ejournal.core.model.UploadItem;
import com.teamo.ejournal.core.util.UploadUtils;
import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.UserEntity;
import com.teamo.ejournal.service.ArticleServiceImpl;
import com.teamo.ejournal.service.UserServiceImpl;

@Controller
public class ArticleUploadController {
 
	private static final Logger logger = LoggerFactory.getLogger(ArticleUploadController.class);
	
	private static final long MAX_BYTES = 1000000;
	public static final String UPLOAD_NAME = "fileuploadname";
	
    @Autowired
    private ArticleServiceImpl articleService;
    
    @Autowired
    private UserServiceImpl userService;
    
    @RequestMapping(value = "submit_article_vars", method = RequestMethod.POST)
    public @ResponseBody ServerResponse receiveArticleVars(@RequestBody ArticleUpload articleUpload, 
    					Principal principal, HttpServletRequest request,HttpSession session){
    	
    	logger.info("Article received... "+articleUpload);
    	logger.info("Principal: "+principal);
    	
    	ServerResponse sr = new ServerResponse();
    	String serverSavePath;
    	String fileURLPath;
    	
    	//register new user if needed
    	boolean isAuth = true;
    	UserEntity user = null;
    	if (principal != null) user = userService.getUser(principal.getName());
    	if (user == null){
    		isAuth = false;
    		logger.info("user not logged in.");
    		List<Author> authors = articleUpload.getAuthors();
    		if (authors.size() > 0 && !authors.get(0).getEmail().isEmpty()){
        		try{
        			user = userService.registerNewTempUser(authors.get(0).getEmail());
        		}catch(Exception ex){
        			logger.info("error registering user with username: "+authors.get(0).getEmail());
        			sr.setResponse("fail");
        			sr.getArgs().add("Could not register new user.");
        			return sr;
        		}
    			userService.updateRolesForArticleUploader(user);
    		} else {
    			sr.setResponse("fail");
    			sr.getArgs().add("Missing author's email");
    			return sr;
    		}
    	}
    	
    	Article article = new Article();
    	
    	//load original filename from session and delete it from session:
    	String origFilename = (String) session.getAttribute(UPLOAD_NAME);
    	session.removeAttribute(UPLOAD_NAME);
    	//save file
		try{
			logger.info("Calling uploadutils...");
			//how to put on .jsp: response.sendRedirect(request.getContextPath() + "/seja/izpisknjig.jsp");
			int nextVersion = articleService.getNextVersionNumber(article);
	    	serverSavePath = UploadUtils.getServerSavingPathForUser(
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
		
		logger.info("File '" + origFilename + "' uploaded successfully");
		logger.info("Server path: "+serverSavePath);
		logger.info("Relative URL: "+fileURLPath);
    	
		//save article
		article.lastVersionURL = fileURLPath;
		try {
			articleService.updateArticleUploaded(user, isAuth, article, articleUpload);
			sr.setResponse("ok");
		} catch (ConstraintViolationException cve) {
			logger.info("Error validating article: "+article);
			sr.setResponse("fail");
			sr.getArgs().add("Error validating article.");
		} catch (HibernateException he){
			logger.info("Error saving article: "+article);
			sr.setResponse("fail");
			sr.getArgs().add("Error saving article.");
		}
		
		return sr;
    }
    
    @RequestMapping(value = "submit_article_file",method=RequestMethod.POST)
	public @ResponseBody ServerResponse processArticleUpload(MultipartFile file, HttpServletRequest request, HttpSession session) throws IOException {
		
    	logger.info("File received: "+file);
    	
    	ServerResponse sr = new ServerResponse();
    	
		if (file == null || file.getSize() == 0) {
			// hmm, that's strange, the user did not upload anything
			logger.info("No file uploaded.");
			sr.setResponse("fail");
			sr.getArgs().add("No file detected");
		} else if (file.getSize() > MAX_BYTES){
			logger.info("File exceeded limit of "+MAX_BYTES/1000000.0+" MB.");
			sr.setResponse("fail");
			sr.getArgs().add("File greater than "+MAX_BYTES/1000000.0+" MB.");
		} else {
			//save file in temp folder
			UploadUtils.saveTempFile(file, request.getServletContext().getRealPath("/"));
			//save filename in session
			session.setAttribute(UPLOAD_NAME, file.getOriginalFilename());
			logger.info("Temp file saved in: "+UploadUtils.getTempPath(request.getServletContext().getRealPath("/")));
			sr.setResponse("ok");
		}
		
		return sr;
	}
   
}