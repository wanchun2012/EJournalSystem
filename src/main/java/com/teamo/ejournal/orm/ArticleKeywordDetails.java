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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "keyword"))
public class ArticleKeywordDetails {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String keyword;

	@ManyToMany(mappedBy = "keywordCollection")
	private Collection<Article> keywordCollection;

	public ArticleKeywordDetails() {
	}

	public ArticleKeywordDetails(int id, String keyword) {
		this.id = id;
		this.keyword = keyword;
	}
	
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Collection<Article> getKeywordCollection() {
		return keywordCollection;
	}

	public void setKeywordCollection(Collection<Article> keywordCollection) {
		this.keywordCollection = keywordCollection;
	}

	@Override
	public String toString() {
		return "ArticleKeywordDetails [id=" + id + ", keyword=" + keyword + "]";
	}
	
}
