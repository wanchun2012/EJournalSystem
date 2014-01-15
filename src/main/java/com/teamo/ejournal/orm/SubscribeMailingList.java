package com.teamo.ejournal.orm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class SubscribeMailingList {
	@Id
	@GeneratedValue
	@Column
	private Integer id;

	@NotEmpty
	@Column
	private String email; //email
 
	@JoinTable(name="SubscribeKeyword",joinColumns={
	@JoinColumn(name="subscribe_id",referencedColumnName="id")}, inverseJoinColumns={
	@JoinColumn(name="keyword_id",referencedColumnName="id")})
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<ArticleKeywordDetails> subscribeKeywords;

	@Column
	private Boolean subscribeNextEditions;

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

	public Set<ArticleKeywordDetails> getSubscribeKeywords() {
		return subscribeKeywords;
	}

	public void setSubscribeKeywords(Set<ArticleKeywordDetails> subscribeKeywords) {
		this.subscribeKeywords = subscribeKeywords;
	}

	public Boolean getSubscribeNextEditions() {
		return subscribeNextEditions;
	}

	public void setSubscribeNextEditions(Boolean subscribeNextEditions) {
		this.subscribeNextEditions = subscribeNextEditions;
	}
	
	
}
