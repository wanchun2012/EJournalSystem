package com.teamo.ejournal.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamo.ejournal.core.model.SubscribableEmail;
import com.teamo.ejournal.core.model.SubscribableKeyword;
import com.teamo.ejournal.service.ReaderServiceImpl;
import com.teamo.ejournal.service.UserServiceImpl;

@Controller
@RequestMapping("/subscribe")
public class SubscribeController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private ReaderServiceImpl readerService;
	
	private static final Logger logger = LoggerFactory.getLogger(SubscribeController.class);
	
	@RequestMapping(value="/keyword",method=RequestMethod.POST)
	public @ResponseBody String subscribeKeyword(@RequestBody SubscribableKeyword subs){
	
		logger.info("subscribe with data: "+subs);
		
		//subscribe keyword
		if (!subs.getEmail().equals("")){
			logger.info("subscribe keyword");
			//if (userService.registerNewTempUserIfDoesntExist(subs.getEmail()))
				readerService.subscribeKeywords(subs.getEmail(), subs.getKeyword());	
		}
		
		return "ok";
	}
	
	@RequestMapping(value="/edition",method=RequestMethod.POST)
	public @ResponseBody String subscribeKeyword(@RequestBody SubscribableEmail subs){
	
		logger.info("subscribe with data: "+subs);
		
		//subscribe edition
		if (!subs.getEmail().equals("")){
			logger.info("subscribe edition");
			//if (userService.registerNewTempUserIfDoesntExist(subs.getEmail()))
				readerService.subscribeNextEditions(subs.getEmail());	
		}
		
		return "ok";
	}
}
