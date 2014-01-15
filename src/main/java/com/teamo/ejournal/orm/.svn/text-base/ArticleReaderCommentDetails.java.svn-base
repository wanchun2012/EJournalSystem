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

@Entity 
public class ArticleReaderCommentDetails {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@Column
	private String comment;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "comment", cascade = CascadeType.ALL)
	private ArticleReaderCommentResponseDetails response;

    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "article_id")  
	private Article article;
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ArticleReaderCommentResponseDetails getResponse() {
		return response;
	}

	public void setResponse(ArticleReaderCommentResponseDetails response) {
		this.response = response;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
}
