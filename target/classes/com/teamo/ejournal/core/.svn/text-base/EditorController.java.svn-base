package com.teamo.ejournal.core;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamo.ejournal.core.model.EditorAddEmail;
import com.teamo.ejournal.core.model.IndicateEditor;
import com.teamo.ejournal.core.model.JournalSettingsForm;
import com.teamo.ejournal.core.model.ServerResponse;
import com.teamo.ejournal.orm.JournalSetting;
import com.teamo.ejournal.service.EditorServiceImpl;
import com.teamo.ejournal.service.ReaderServiceImpl;

@Controller
public class EditorController {
	
	private static final Logger logger = LoggerFactory.getLogger(EditorController.class);
	
	@Autowired
	private EditorServiceImpl editorService;
	
	@RequestMapping(value="/editor/{editorName}",method = RequestMethod.GET)
	@PreAuthorize("(hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')) && (hasPermission(#editorName,'sameID'))")
	public String home(@PathVariable String editorName,Model model){
		logger.info("editor home for "+editorName);
		
		model.addAttribute("journalSettings", editorService.getCurrentJournalSetting());
		
		return "editor/index";
	}

	@RequestMapping(value = "/editor/{editorName}/loadContent", method = RequestMethod.GET)
	@PreAuthorize("(hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')) && (hasPermission(#editorName,'sameID'))")
	public String loadContent(@RequestParam String cname,@PathVariable String editorName, Model model) {
		
		logger.info("editorname: "+ editorName);
		logger.info("Loading content, cname: "+cname);

		model.addAttribute("journalSettings", editorService.getCurrentJournalSetting());

		//special contents added to .jsp:
		if (cname.equals("home")){
			model.addAttribute("listArticles", editorService.displayAllArticleForEditor());
		} else if (cname.equals("userslit")){
			model.addAttribute("listUsers", editorService.displayAllUsers());
		} else if (cname.equals("journal-settings")){
			//model.addAttribute("journalSettings", editorService.getCurrentJournalSetting());
		}
		
		return "editor/" + cname;
	}
	
	//AJAX
	@RequestMapping(value = "/add_new_editor_by_email", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
	public @ResponseBody ServerResponse addNewEditorEmail(@Valid @RequestBody EditorAddEmail addEmail, BindingResult result) {
		
		logger.info("add email: "+ addEmail+" ; result: "+result);
		
		ServerResponse sr = new ServerResponse();
		if (sr.bindErrors(result)) return sr;
		
		if(addEmail.getEditorEmail().isEmpty()){
			sr.setResponse("fail");
			sr.getArgs().add("Email is empty");
		} else {
			//email validated, keep going
			try {
				editorService.registerNewEditor(addEmail.getEditorEmail());
				sr.setResponse("ok");
				sr.getArgs().add("Editor added successfully!");
			} catch (MailException e) {
				e.printStackTrace();
				logger.info("Couldn't send email to: "+addEmail.getEditorEmail());
				sr.setResponse("fail");
	        	sr.getArgs().add("Error: Couldn't send email.");
			}
		}
		
		return sr;
	}
	
	//AJAX
	@RequestMapping(value = "/indicate", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
	public @ResponseBody ServerResponse indicate(@Valid @RequestBody IndicateEditor indicateEditor, BindingResult result) {
		
		logger.info("indicate username: "+indicateEditor.getUsername());
		
		ServerResponse sr = new ServerResponse();
		if (sr.bindErrors(result)) return sr;
		
		if (!indicateEditor.getUsername().isEmpty()){
			try {
				editorService.appointEditor(indicateEditor.getUsername());
			} catch (Exception e) {
				logger.info("failed to indicate user");
				e.printStackTrace();
				sr.setResponse("fail");
				sr.getArgs().add("Couldn't indicate user");
			}
		}

		sr.setResponse("ok");
		return sr;
	}
	
	//AJAX
	@RequestMapping(value = "/retire", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
	public @ResponseBody ServerResponse retire(Principal principal) {
		
		logger.info("retire user: "+principal);
		
		ServerResponse sr = new ServerResponse();

		if (principal == null){
			sr.setResponse("fail");
			sr.getArgs().add("No user logged in");
			return sr;
		}
		
		if(editorService.selfRetired(principal.getName())){
			sr.setResponse("ok");
			sr.getArgs().add("User deleted");
		} else {
			sr.setResponse("fail");
			sr.getArgs().add("Couldn't retire user");
		}
		
		return sr;
	}
	
	//AJAX
	@RequestMapping(value = "/setup_journal", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
	public @ResponseBody ServerResponse setupJournal(@RequestBody JournalSettingsForm journalSettingsForm, BindingResult result) {
		
		logger.info("journal settings: "+journalSettingsForm);
		
		ServerResponse sr = new ServerResponse();
		if (sr.bindErrors(result)) return sr;

		try {
			editorService.updateJournalSetting(journalSettingsForm);	
		} catch (Exception e) {
			e.printStackTrace();
			sr.setResponse("fail");
			sr.getArgs().add("Could not setup journal settings correctly: "+e);
			return sr;
		}
		
		
		sr.setResponse("ok");
		return sr;
	}
	
	//AJAX
	@RequestMapping(value = "/publish_article", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
	public @ResponseBody ServerResponse publishArticle(@RequestParam String articleId) {
		
		logger.info("publish articleId: "+articleId);
		
		ServerResponse sr = new ServerResponse();

		try {
			editorService.publishArticle(Integer.parseInt(articleId));
		} catch (Exception e) {
			sr.setResponse("fail");
			sr.getArgs().add("Couldn't publish article");
			return sr;
		}
		
		sr.setResponse("ok");
		return sr;
	}
	
	//AJAX
	@RequestMapping(value = "/decline_article", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
	public @ResponseBody ServerResponse declineArticle(@RequestParam String articleId) {
		
		logger.info("decline articleId: "+articleId);
		
		ServerResponse sr = new ServerResponse();

		try {
			editorService.rejectArticle(Integer.parseInt(articleId));	
		} catch (Exception e) {
			sr.setResponse("fail");
			sr.getArgs().add("Couldn't reject article");
			return sr;
		}
		
		sr.setResponse("ok");
		return sr;
	}
	
	
}
