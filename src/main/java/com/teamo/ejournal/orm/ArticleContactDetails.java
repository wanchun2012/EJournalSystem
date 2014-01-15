package com.teamo.ejournal.orm;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class ArticleContactDetails {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String email;
	
	@Column
	private String surname;
	
	@Column
	private String firstname;
	
	
	@Column
	private String affiliation;

	@ManyToMany(mappedBy = "contactCollection")
	private Collection<Article> contactCollection;
	
	public ArticleContactDetails() {
	}

	
	

	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getSurname() {
		return surname;
	}





	public void setSurname(String surname) {
		this.surname = surname;
	}





	public String getFirstname() {
		return firstname;
	}





	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}





	public Collection<Article> getContactCollection() {
		return contactCollection;
	}





	public void setContactCollection(Collection<Article> contactCollection) {
		this.contactCollection = contactCollection;
	}





	public String getAffiliation() {
		return affiliation;
	}




	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}




	@Override
	public String toString() {
		return "ArticleContactDetails [id=" + id + ", email=" + email + "]";
	}
	
}
