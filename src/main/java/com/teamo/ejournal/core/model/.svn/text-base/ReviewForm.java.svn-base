package com.teamo.ejournal.core.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ReviewForm {

	public ReviewForm() {
	}
	
	@NotNull
	private Integer articleId;
	@NotEmpty
	private String summary;
	private Integer score;
	private Integer expertise;
	@NotNull
	private List<String> commentsCritisize;
	private List<String> commentsTypographic;
	private List<String> commentsSecret;
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getExpertise() {
		return expertise;
	}
	public void setExpertise(Integer expertise) {
		this.expertise = expertise;
	}

	@Override
	public String toString() {
		return "ReviewForm [articleId=" + articleId + ", summary=" + summary
				+ ", score=" + score + ", expertise=" + expertise
				+ ", commentsCritisize=" + commentsCritisize
				+ ", commentsTypographic=" + commentsTypographic
				+ ", commentsSecret=" + commentsSecret + "]";
	}
	public List<String> getCommentsCritisize() {
		return commentsCritisize;
	}
	public void setCommentsCritisize(List<String> commentsCritisize) {
		this.commentsCritisize = commentsCritisize;
	}
	public List<String> getCommentsTypographic() {
		return commentsTypographic;
	}
	public void setCommentsTypographic(List<String> commentsTypographic) {
		this.commentsTypographic = commentsTypographic;
	}
	public List<String> getCommentsSecret() {
		return commentsSecret;
	}
	public void setCommentsSecret(List<String> commentsSecret) {
		this.commentsSecret = commentsSecret;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	
}
