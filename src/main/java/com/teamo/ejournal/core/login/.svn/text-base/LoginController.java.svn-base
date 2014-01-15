package com.teamo.ejournal.core.login;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamo.ejournal.core.util.EmailUtils;

@Controller
public class LoginController{

	@Autowired
	private EmailUtils emailUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/logged", method = RequestMethod.GET)
	public String logged(ModelMap model, Principal principal){
		logger.info("logged as "+principal.getName()+" with hash "+principal.hashCode());
		
		model.addAttribute("username", principal.getName());
		
		return "logged";
	}
	
	@RequestMapping(value = "/fail", method = RequestMethod.GET)
	public String fail(Model model){
		logger.info("failure");
		
		model.addAttribute("loginStatus", "Failure to login, try again hacker!!!");
		
		return "/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Principal p){
		logger.info("logout for "+p.getName());
		
		return "redirect:j_spring_security_logout";
	}
	
	@RequestMapping(value="/maillogin",method=RequestMethod.POST)
	public @ResponseBody String loginMail(){
		
		try{
			emailUtils.sendEmail("zebaum@gmail.com", "ello", "u r cute");
		}catch(MailException mex){
			return "error: couldnt send mail!";
		}
		
		return "mail sent!";
	}
	
}
