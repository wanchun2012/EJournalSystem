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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Entity 
public class Article
{
	public static final int TEMP = -1;
	public static final int INIT = 0; // need review
	public static final int REVIEW_1 = 1;  // need update
	public static final int REVIEW_2 = 2;  // need finish
	public static final int REVIEW_FINISHED = 3;
	public static final int WAITING_PUBLISHED = 4;
	public static final int PUBLISHED = 5;
	public static final int REJECTED = 6;
	
	@Transient
	private String friendlyStatus;
	
	public String getFriendlyStatus() {
		switch(status){
		case TEMP:
			friendlyStatus = "Temporary";
			break;
		case INIT:
			friendlyStatus = "Initial";
			break;
		case REVIEW_1:
			friendlyStatus = "1st Review";
			break;
		case REVIEW_2:
			friendlyStatus = "2nd Review";
			break;
		case REVIEW_FINISHED:
			friendlyStatus = "Completed Reviews";
			break;
		case WAITING_PUBLISHED:
			friendlyStatus = "Waiting to be published";
			break;
		case PUBLISHED:
			friendlyStatus = "Published";
			break;
		case REJECTED:
			friendlyStatus = "Rejected";
			break;
		}
		return friendlyStatus;
	}
	
	@Id
	@Column 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column
	@NotEmpty
    private String title;
	
	@Column (name="abstract")
	@NotEmpty
    private String articleAbstract;
	
	@Column
	private int status;
	
	@Column
	@Type(type="date")
	private Date whenUpdated;
	
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "journal_id")  
	private Journal journal;
	
	@Column
	private Integer numberReviewed;
 
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "author_id")  
	private UserEntity author;
	 
    @OneToMany(mappedBy="article", cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    private Set<ArticleReviewDetails> reviewCollection;
    
    @OneToMany(mappedBy="article", cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    private Set<ArticleReaderCommentDetails> readerComment;
 
	@JoinTable(name="ArticleKeyword",joinColumns={
			@JoinColumn(name="article_id",referencedColumnName="id")}, inverseJoinColumns={
			@JoinColumn(name="keyword_id",referencedColumnName="id")})
	@ManyToMany(fetch = FetchType.EAGER)
    private Set<ArticleKeywordDetails> keywordCollection;
	
	@JoinTable(name="ArticleContact",joinColumns={
			@JoinColumn(name="article_id",referencedColumnName="id")}, inverseJoinColumns={
			@JoinColumn(name="contact_id",referencedColumnName="id")})
			@ManyToMany(fetch = FetchType.EAGER)
    private Set<ArticleContactDetails> contactCollection; 
	
    @OneToMany(mappedBy="article", cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    private Set<ArticleVersionDetails> versionCollection;
	
	@Transient
	public String lastVersionURL;
	
	@Transient 
	private ArticleVersionDetails lastVersion;
	
	@Transient 
	private ArticleVersionDetails firstVersion;
	
	public ArticleVersionDetails getLastVersion() {
		int greater = -9;
		for (ArticleVersionDetails version : versionCollection) {
			if (version.getVersion() > greater){
				greater = version.getVersion();
				lastVersion = version;
			}
		}
		return lastVersion;
	}
	
	public ArticleVersionDetails getFirstVersion() {
		int lowest = Integer.MAX_VALUE;
		for (ArticleVersionDetails version : versionCollection) {
			if (version.getVersion() < lowest){
				lowest = version.getVersion();
				firstVersion = version;
			}
		}
		return lastVersion;
	}
	
	@Transient
	private String friendlyDate;
	
	public String getFriendlyDate() {
		//special set friendly date
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd MMMM yyyy");
		DateTime jodaDate = new DateTime(whenUpdated);
		friendlyDate = formatter.print(jodaDate);
		return friendlyDate;
	}

	public void setFriendlyDate(String friendlyDate) {
		this.friendlyDate = friendlyDate;
	}

	public Set<ArticleVersionDetails> getVersionCollection() {
		return versionCollection;
	}

	public void setVersionCollection(Set<ArticleVersionDetails> versionCollection) {
		this.versionCollection = versionCollection;
	}

	public Set<ArticleContactDetails> getContactCollection() {
		return contactCollection;
	}

	public void setContactCollection(Set<ArticleContactDetails> contactCollection) {
		this.contactCollection = contactCollection;
	}

	public Set<ArticleKeywordDetails> getKeywordCollection() {
		return keywordCollection;
	}

	public void setKeywordCollection(Set<ArticleKeywordDetails> keywordCollection) {
		this.keywordCollection = keywordCollection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getWhenUpdated() {
		return whenUpdated;
	}

	public void setWhenUpdated(Date whenUpdated) {
		this.whenUpdated = whenUpdated;	
	}
	
	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public Set<ArticleReviewDetails> getReviewCollection() {
		return reviewCollection;
	}

	public void setReviewCollection(Set<ArticleReviewDetails> reviewCollection) {
		this.reviewCollection = reviewCollection;
	}

	public int getNumberReviewed() {
		return numberReviewed;
	}

	public void setNumberReviewed(int numberReviewed) {
		this.numberReviewed = numberReviewed;
	}
 
	public UserEntity getAuthor() {
		return author;
	}

	public void setAuthor(UserEntity author) {
		this.author = author;
	}
 
	public String getLastVersionURL() {
		return lastVersionURL;
	}

	public void setLastVersionURL(String lastVersionURL) {
		this.lastVersionURL = lastVersionURL;
	}

	public Set<ArticleReaderCommentDetails> getReaderComment() {
		return readerComment;
	}

	public void setReaderComment(Set<ArticleReaderCommentDetails> readerComment) {
		this.readerComment = readerComment;
	}
	
	
}
