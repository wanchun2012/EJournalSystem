package com.teamo.ejournal.orm;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Journal {
	@Id
	@Column 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Integer volume;
	
	@Column
	private Integer edition;
 
	@Column
	private Integer isSpecial;
	 
	@Column
	private Integer masterIndex;
	
	@Column
	@Type(type="date")
	private Date whenCreated;
	
    @OneToMany(mappedBy="journal", cascade=CascadeType.ALL)     
	private Set<Article> articleCollection;
    
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}
 
	public int isSpecial() {
		return isSpecial;
	}

	public void setSpecial(int isSpecial) {
		this.isSpecial = isSpecial;
	}
 
	public int getMasterIndex() {
		return masterIndex;
	}

	public void setMasterIndex(int masterIndex) {
		this.masterIndex = masterIndex;
	}

	public Date getWhenCreated() {
		return whenCreated;
	}

	public void setWhenCreated(Date whenCreated) {
		this.whenCreated = whenCreated;
	}

	public Set<Article> getArticleCollection() {
		return articleCollection;
	}

	public void setArticleCollection(Set<Article> articleCollection) {
		this.articleCollection = articleCollection;
	}

    public String toString()
    {
    	return "edition: "+ edition+", volume: "+ volume;
    }
	
	/*
	private Set<ArticleReaderCommentDetails> readerCommentCollection;
    */
	
	
}
