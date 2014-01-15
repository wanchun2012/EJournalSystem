package com.teamo.ejournal.core.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class NewReviewer {

	public NewReviewer() {
	}
	
	@NotEmpty
	@Email
	@Size(min=6,max=25)
	private String username;
	
	@NotEmpty
	@Size(min=3,max=25)
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "NewReviewer [username=" + username + ", password=" + password
				+ "]";
	}
}
