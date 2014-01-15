package com.teamo.ejournal.core.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ServerResponse {

	public ServerResponse() {
		this.args = new ArrayList<String>();
	}

	private String response;
	private List<String> args;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}
	
	public boolean bindErrors(BindingResult result){
		if (result.hasErrors()){
			for(ObjectError error : result.getAllErrors()){
				this.setResponse("fail");
	        	this.getArgs().add("Error: "+error.getDefaultMessage());
			}
			return true;
	    } else return false;
	}
	
}
