package com.teamo.ejournal.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity 
public class ArticleReaderCommentResponseDetails {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@Column
	private String response;

	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private ArticleReaderCommentDetails comment;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public ArticleReaderCommentDetails getComment() {
		return comment;
	}

	public void setComment(ArticleReaderCommentDetails comment) {
		this.comment = comment;
	}


	
	
	
	
}
