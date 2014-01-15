package com.teamo.ejournal.core.login;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamo.ejournal.orm.UserEntity;
import com.teamo.ejournal.service.UserServiceImpl;

import org.springframework.mail.MailException;

@Controller
public class TempRegisterController {
 
	private static final Logger logger = LoggerFactory.getLogger(TempRegisterController.class);
	
    @Autowired
    private UserServiceImpl userService;
 
    @RequestMapping(value="/registerform",method = RequestMethod.GET)
    public String display(Model model) {
    	
    	model.addAttribute("user", new UserEntity());
       
        return "register_form";
    }
 
    @RequestMapping(value="/registerform",method = RequestMethod.POST)
    public String register(@ModelAttribute UserEntity user, BindingResult result) {
    	
    	if(userService.existUser(user.getUsername())){
    		return "register_fail";
    	} else try{
    				logger.info("registering temporary user email: "+user.getUsername());
	    			userService.registerNewTempUser(user);
	    	       	return "register_success";
		    	} catch (MailException mex){
		    		logger.error("failed to register temporary user email.");
		    		return "register_error";
		    	}
    }  
    
    @RequestMapping(value="/change_password_temp_user",method = RequestMethod.GET)
    public String display(){
        return "change_password_temp_user";
    }
 
    @RequestMapping(value="/change_password_temp_user",method = RequestMethod.POST)
    public String changePassword(Principal principal, @RequestParam String newPw) {
    	
    	logger.info("registering as reader username: "+principal.getName());
    	
    	userService.registerTempUserAsReaderWithNewPassword(principal.getName(),newPw);
   	
    	return "change_password_temp_user_success";
    }
}