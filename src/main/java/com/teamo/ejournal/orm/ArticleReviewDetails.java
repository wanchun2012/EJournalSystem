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
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Entity 
public class ArticleReviewDetails {
	 
	public static final int TEMP = 1;
	public static final int SUBMITTED = 2;
	public static final int ACCEPTED = 3;
	public static final int FIRST_REJECTED = 4;
	public static final int SECOND_REJECTED = 5;
	
	@Transient
	private String friendlyStatus;
	
	public String getFriendlyStatus() {
		switch(status){
		case TEMP:
			friendlyStatus = "Temporary";
			break;
		case SUBMITTED:
			friendlyStatus = "Submitted";
			break;
		case ACCEPTED:
			friendlyStatus = "Accepted";
			break;
		case FIRST_REJECTED:
			friendlyStatus = "1st Rejected";
			break;
		case SECOND_REJECTED:
			friendlyStatus = "2nd Rejected";
			break;
		}
		return friendlyStatus;
	}
	
	//Champion
	public static final int SCORE_CHAMPION = 3;
	public static final int SCORE_FAVOURABLE = 2;
	public static final int SCORE_INDIFFERENT = 1;
	public static final int SCORE_DITRACTOR = 0;
	
	@Transient
	private String friendlyScore;
	
	public String getFriendlyScore() {
		switch(score){
		case SCORE_CHAMPION:
			friendlyScore = "Champion";
			break;
		case SCORE_FAVOURABLE:
			friendlyScore = "Favourable";
			break;
		case SCORE_INDIFFERENT:
			friendlyScore = "Indifferent";
			break;
		case SCORE_DITRACTOR:
			friendlyScore = "Ditractor";
			break;
		}
		return friendlyScore;
	}
	
	//level
	public static final int LEVEL_EXPERT = 2;
	public static final int LEVEL_KNOWLEDGEABLE = 1;
	public static final int LEVEL_OUTSIDER = 0;

	@Transient
	private String friendlyExpertise;
	
	public String getFriendlyExpertise() {
		switch(level){
		case LEVEL_EXPERT:
			friendlyExpertise = "Expert";
			break;
		case LEVEL_KNOWLEDGEABLE:
			friendlyExpertise = "Knowledgeable";
			break;
		case LEVEL_OUTSIDER:
			friendlyExpertise = "Outsider";
			break;
		}
		return friendlyExpertise;
	}
	
	@Id
	@Column 
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	/*
	@Column
	private int reviewerid;
	*/
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "article_id")  
	private Article article;
 
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "reviewer_id")  
	private UserEntity reviewer;
 
	@Column
	private int score;
	
	@Column
	private int level;

	@Column
	private String summary;
	 
	@OneToMany(mappedBy="review", cascade=CascadeType.ALL, fetch = FetchType.EAGER)  
    private Set<ArticleReviewCommentDetails> commentCollection;
	
	@Column
	@Type(type="date")
	private Date whenUpdated;
	
	@Transient
	private String friendlyDate;
	
	public String getFriendlyDate() {
		//special set friendly date
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd MMMM yyyy");
		DateTime jodaDate = new DateTime(whenUpdated);
		friendlyDate = formatter.print(jodaDate);
		return friendlyDate;
	}
	
	@Column
	private int updatedScore;
	
	@Column
	private String firstRejectedComment;
	
	@Column
	@Type(type="date")
	private Date whenfirstResponse;
	
	@Column
	private String secondRejectedComment;
	
	@Column
	@Type(type="date")
	private Date whenSecondResponse;
	
	@Column
	private int rejectTimesCount;
	
	@Column
	private int status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
/*
	public int getReviewerid()
	{
		return reviewerid;
	}

	public void setReviewerid(int reviewerid)
	{
		this.reviewerid = reviewerid;
	}
*/
	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getWhenUpdated() {
		return whenUpdated;
	}

	public void setWhenUpdated(Date whenUpdated) {
		this.whenUpdated = whenUpdated;
	}

	public int getUpdatedScore()
	{
		return updatedScore;
	}

	public void setUpdatedScore(int updatedScore)
	{
		this.updatedScore = updatedScore;
	}

	public String getFirstRejectedComment()
	{
		return firstRejectedComment;
	}

	public void setFirstRejectedComment(String firstRejectedComment)
	{
		this.firstRejectedComment = firstRejectedComment;
	}

	public Date getWhenfirstResponse()
	{
		return whenfirstResponse;
	}

	public void setWhenfirstResponse(Date whenfirstResponse)
	{
		this.whenfirstResponse = whenfirstResponse;
	}

	public String getSecondRejectedComment()
	{
		return secondRejectedComment;
	}

	public void setSecondRejectedComment(String secondRejectedComment)
	{
		this.secondRejectedComment = secondRejectedComment;
	}

	public Date getWhenSecondResponse()
	{
		return whenSecondResponse;
	}

	public void setWhenSecondResponse(Date whenSecondResponse)
	{
		this.whenSecondResponse = whenSecondResponse;
	}

	public int getRejectTimesCount()
	{
		return rejectTimesCount;
	}

	public void setRejectTimesCount(int rejectTimesCount)
	{
		this.rejectTimesCount = rejectTimesCount;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
 
	public UserEntity getReviewer() {
		return reviewer;
	}

	public void setReviewer(UserEntity reviewer) {
		this.reviewer = reviewer;
	}

	public Set<ArticleReviewCommentDetails> getCommentCollection() {
		return commentCollection;
	}

	public void setCommentCollection(
			Set<ArticleReviewCommentDetails> commentCollection) {
		this.commentCollection = commentCollection;
	}

	 
	
}
