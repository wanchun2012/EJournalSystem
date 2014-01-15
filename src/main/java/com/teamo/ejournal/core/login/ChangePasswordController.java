package com.teamo.ejournal.core.login; 

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamo.ejournal.orm.UserEntity;
import com.teamo.ejournal.service.UserServiceImpl;

@Controller
@RequestMapping("/changepassword")
public class ChangePasswordController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChangePasswordController.class);
    
	@Autowired
    private UserServiceImpl userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String diplay() {
       
        return "changepassword";
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String changePassword(@RequestParam String oldPw,@RequestParam String newPw, Principal principal) {
    	
    	UserEntity tempUser = userService.getUser(principal.getName());
    	
    	logger.info("tempuser: "+tempUser.getUsername()+tempUser.getPassword());
    	
    	if(tempUser != null && tempUser.getPassword().equals(oldPw))
    	{
    		tempUser.setPassword(newPw);
    		userService.updateUser(tempUser);	 
    	} else {
    		//error: user not found or old password is invalid
    		return "/";
    	}
    	
    	//success: changed
    	return "redirect:/";
    }
}