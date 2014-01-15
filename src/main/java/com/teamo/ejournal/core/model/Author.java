package com.teamo.ejournal.core.model;

public class Author {
	public Author() {
	}
	private String firstname;
	private String secondname;
	private String email;
	private String affiliation;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	@Override
	public String toString() {
		return "Author [firstname=" + firstname + ", secondname="
				+ secondname + ", email=" + email + ", affiliation="
				+ affiliation + "]";
	}
}
