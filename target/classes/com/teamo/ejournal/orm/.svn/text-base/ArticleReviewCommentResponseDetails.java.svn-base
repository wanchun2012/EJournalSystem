package com.teamo.ejournal.orm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.Table;
@Entity 
public class ArticleReviewCommentResponseDetails {
	@Id
	 
	@Column
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="comment"))
	private Integer id;
	
	@Column
	private String response;
  
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private ArticleReviewCommentDetails comment;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public ArticleReviewCommentDetails getComment() {
		return comment;
	}

	public void setComment(ArticleReviewCommentDetails comment) {
		this.comment = comment;
	}

	 
	

}
