package com.teamo.ejournal.core;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.teamo.ejournal.core.model.UploadItem;
import com.teamo.ejournal.core.util.AjaxUtils;
import com.teamo.ejournal.core.util.UploadUtils;

//@Controller
//@RequestMapping("/upload")
public class UploadController {

/*
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	private static final long MAX_BYTES = 1000000;
	
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void fileUploadForm(Model model) {
		//need to add this model attribute, so the form can display it properly
        model.addAttribute("uploadItem", new UploadItem());
        
		//will return default view 'upload' since it's mapped to '/upload'
	}

	@RequestMapping(method=RequestMethod.POST)
	public void processUpload(UploadItem uploadItem, BindingResult result, Model model, HttpServletRequest request) throws IOException {
		
		logger.info("aaa result "+result+ " ;;; uploaditem "+uploadItem);
		
		// not sure if it can even be called.
		if (result.hasErrors())
	    {
	      for(ObjectError error : result.getAllErrors())
	      {
	        System.err.println("Error: " + error.getCode() +  " - " + error.getDefaultMessage());
	        model.addAttribute("message", "An error ocurred.");
	      }
	      return;
	    }
		
		if (uploadItem.getFileData() == null || uploadItem.getFileData().getSize() == 0) {
			// hmm, that's strange, the user did not upload anything
			model.addAttribute("message", "No file uploaded.");
		} else if (uploadItem.getFileData().getSize() > MAX_BYTES){
			model.addAttribute("message", "File exceeded limit of "+MAX_BYTES/1000.0+" MB.");
		} else {
			try{
				UploadUtils.saveFile(uploadItem,request.getServletContext().getRealPath("/"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
	            throw e;
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw e;
	        }
			model.addAttribute("message", "File '" + uploadItem.getFileData().getOriginalFilename() + "' uploaded successfully");   
		}
	}
	*/
	
	
}
