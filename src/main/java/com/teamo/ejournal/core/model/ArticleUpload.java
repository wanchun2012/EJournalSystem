package com.teamo.ejournal.core.model;

import java.util.ArrayList;
import java.util.List;

public class ArticleUpload {
	
	public ArticleUpload() {
		this.keywords = new ArrayList<String>();
		this.authors = new ArrayList<Author>();
	}

	private String title;
	private List<String> keywords;
	private String paperAbstract;
	private List<Author> authors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public String getPaperAbstract() {
		return paperAbstract;
	}

	public void setPaperAbstract(String paperAbstract) {
		this.paperAbstract = paperAbstract;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "ArticleUpload [title=" + title
				+ ", keywords=" + keywords + ", paperAbstract=" + paperAbstract
				+ ", authors=" + authors + "]";
	}
}
