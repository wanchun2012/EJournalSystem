package com.teamo.ejournal.orm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity 
public class ArticleReviewCommentDetails {

	public static final int COMMENT_TYPE_CRITICISM = 0; 
	public static final int COMMENT_TYPE_SMALL_ERROR = 1;
	public static final int COMMENT_TYPE_SECRET = 2;
	
	@Transient
	private String friendlyType;
	
	public String getFriendlyType() {
		switch(commentType){
		case COMMENT_TYPE_CRITICISM:
			friendlyType = "Criticism";
			break;
		case COMMENT_TYPE_SMALL_ERROR:
			friendlyType = "Typographic error";
			break;
		case COMMENT_TYPE_SECRET:
			friendlyType = "Secret";
			break;
		}
		return friendlyType;
	}
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
 
	@Column
	private int commentType;
	
	@Column
	private String comment;
	
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "review_id")  
	private ArticleReviewDetails review;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "comment", cascade = CascadeType.ALL)
	private ArticleReviewCommentResponseDetails response;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommentType() {
		return commentType;
	}

	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ArticleReviewDetails getReview() {
		return review;
	}

	public void setReview(ArticleReviewDetails review) {
		this.review = review;
	}

	public ArticleReviewCommentResponseDetails getResponse() {
		return response;
	}

	public void setResponse(ArticleReviewCommentResponseDetails response) {
		this.response = response;
	}
	
	public String toString()
	{
		return "comment:"+comment;
	}
}
