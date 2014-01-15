package com.teamo.ejournal.core.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamo.ejournal.core.util.EmailUtils;
import com.teamo.ejournal.orm.UserEntity;
import com.teamo.ejournal.service.UserServiceImpl;

import org.springframework.mail.MailException;
 
@Controller
@RequestMapping("/forgottenpassword")
public class ForgottenPasswordController {
	
	private static final Logger logger = LoggerFactory.getLogger(ForgottenPasswordController.class);
    
	@Autowired
    private UserServiceImpl userService;
 
	@Autowired
    private EmailUtils emailUtils;
 
    @RequestMapping(method = RequestMethod.GET)
    public String display(Model model) {

    	model.addAttribute("user",new UserEntity());
       
        return "forgottenpassword";
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String register(@RequestParam String username){
    	//ps. username = email
    	
    	logger.info("username: "+username);
    	
    	if(!userService.existUser(username)){
    		return "forgotten_password_fail";
    	}
    	else{
    		String body= "Your password is: "+
    				userService.getUser(username).getPassword()
    				+"\n"+"Regards,\n"+"teamo company";
    		try{
    			emailUtils.sendEmail(username,"Forgotten password",body);
    			return "forgotten_password_success";
    		}catch (MailException mex){
    			return "forgotten_password_fail";
    		}
    	}
    }
}