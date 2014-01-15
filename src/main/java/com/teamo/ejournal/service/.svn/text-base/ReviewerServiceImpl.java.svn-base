package com.teamo.ejournal.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
 
import java.util.Set;

import org.hibernate.HibernateException;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamo.ejournal.core.model.ArticleUpload;
import com.teamo.ejournal.core.model.ReviewForm;
import com.teamo.ejournal.core.util.EmailUtils;
import com.teamo.ejournal.dao.ArticleDAOImpl;
import com.teamo.ejournal.dao.ReviewDAOImpl;
import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.ArticleKeywordDetails;
import com.teamo.ejournal.orm.ArticleReviewCommentDetails;
import com.teamo.ejournal.orm.ArticleReviewCommentResponseDetails;
import com.teamo.ejournal.orm.ArticleReviewDetails;
import com.teamo.ejournal.orm.ArticleVersionDetails;
import com.teamo.ejournal.orm.Role;
import com.teamo.ejournal.orm.UserEntity;

@Service("reviewerService")
@Transactional
public class ReviewerServiceImpl extends UserServiceImpl {
	
	@Autowired
    private ArticleDAOImpl articleDAO;
	
	@Autowired
    private ReviewDAOImpl reviewDAO;
	
	@Autowired
	private EmailUtils emailUtils;
	
	public void addComment(ArticleReviewCommentDetails comment)
	{
		reviewDAO.addReviewComment(comment);
	}
	
	public void updateComment(ArticleReviewCommentDetails comment)
	{
		reviewDAO.updateReviewComment(comment);
	}
	
	public void addResponse(ArticleReviewCommentResponseDetails response)
	{
		reviewDAO.addReviewCommentResponse(response);
	}
	
    //1.get all available articles to reviewer
	public Set<Article> displayArticleForReviewer(String username, int limit)
    {
		Set<Article> downloadedCollection = getUser(username).getDownloadedArticle();
		Set<Article> uploadedCollection = getUser(username).getArticleCollection();
		Set<Article> resultCollection = articleDAO.displayArticleForReviewer(limit);
		resultCollection.removeAll(downloadedCollection);
		resultCollection.removeAll(uploadedCollection);
    	return resultCollection;
    }
	
	//2.display downloaded article intput username
	public Set<Article> displayDownloadedArticleForReviewer(String username)
	{
		Set<Article> downloadedCollection = getUser(username).getDownloadedArticle();
		return downloadedCollection;
	}
	
	//3.set article has been downloaded. username article
	public void downloadArticleToReview (String username, Set<Integer> articlesid) // set<int> articleid // boolean try/catch block
    {
    	UserEntity user = getUser(username);
    	
    	Set<Article> userDownloadedArticleCollection = new HashSet<Article>();
    	userDownloadedArticleCollection = user.getDownloadedArticle();
    	
    	Set<Article> articles = articleDAO.getReviewCollectionArticlesByIds(articlesid);
    	userDownloadedArticleCollection.addAll(articles);
    		
    	Iterator it = articles.iterator();   	
    	while(it.hasNext())
    	{
    		Article article = (Article) it.next();
    		
    		ArticleReviewDetails review = new ArticleReviewDetails();   		
    		review.setWhenUpdated(new Date());
    		review.setArticle(article);
    		review.setReviewer(user);
    		
    		reviewDAO.addReview(review);
    		if(article.getNumberReviewed() == 2)
    		{
    			article.setNumberReviewed(3);
    			article.setStatus(Article.REVIEW_1); // article under review stage 1
    		}
    		else
    		{
    			article.setNumberReviewed(article.getNumberReviewed()+1);
    		}
    		articleDAO.updateArticle(article); // review will be automatically added
    		
    		if(isAuthor(username))
    		{
    			user.setNumberPublishAvailable(user.getNumberPublishAvailable()+1);
    		}
 
    	}
 
    	int numberReviewAvailable = user.getNumberReviewAvailable()-articles.size();
    	user.setNumberReviewAvailable(numberReviewAvailable);
    	updateUser(user);
    }
	
	//4.reviewable
	public boolean reviewerReviewable(String username)
	{
		UserEntity user = getUser(username);
		return user.getNumberReviewAvailable()>0;
	}
	
    //5. 
    public void submitInitArticleReview(String username, ReviewForm rf) throws HibernateException
    {
    	int reviewerid = getUser(username).getId();
    	int articleid = rf.getArticleId();
    	
    	ArticleReviewDetails review = getReviewByReviewerIdAndArticleId(reviewerid, articleid);
    	 
    	review.setWhenUpdated(new Date());
    	review.setStatus(ArticleReviewDetails.TEMP);
    	reviewDAO.updateReview(review);
    	convertModelAndAddReview (review,rf);
    	
    	try {
    		emailUtils.sendEmail(username, "Review received!", "Your review for article '"+review.getArticle().getTitle()+"' was received successfully.\nRegards,\nTeamo company");
		} catch (Exception e) {
			//couldn't send email, but it's not very important.
			e.printStackTrace();
		}
    	
    }
    
    
    public void submitRevisedArticleReview(String username, Article article, 
    		ArticleReviewDetails review, Set<ArticleReviewCommentDetails> comments)
    {
    	if(review.getStatus()==ArticleReviewDetails.TEMP)
    	{
    		Iterator it = comments.iterator();
        	while(it.hasNext())
        	{
        		ArticleReviewCommentDetails comment = (ArticleReviewCommentDetails) it.next();
        		comment.setReview(review);
        		
        	}
    	    reviewDAO.updateReview(review);
    	}
    }
 
	public void submitFirstArticleReviewDecision()
    {
    	// check if final
		// update article from author
		// update article from reviewer
    }

    public void submitSecondArticleReviewDecision(String username, Article article, ArticleReviewDetails review)
    {
    	// check if final
		// update article from author
		// update article from reviewer
    }
    
	public boolean reviewRevisable(ArticleReviewDetails review)
	{
		return review.getStatus()==ArticleReviewDetails.TEMP;
	}
    
	public ArticleReviewDetails getReviewByReviewerIdAndArticleId(int reviewerid, int articleid)
	{
		ArticleReviewDetails review = reviewDAO.getReviewByReviewerIdAndArticleId(reviewerid, articleid);
		DateTime dtReview = new DateTime(review.getWhenUpdated());
		DateTime dtNow = new DateTime(new Date());
		if(Days.daysBetween(dtReview, dtNow).getDays()>7)
		{
			review.setStatus(ArticleReviewDetails.SUBMITTED);
			reviewDAO.updateReview(review);
		}
		return review;
	}
		
   public Set<ArticleReviewDetails> getReviewByReviewerIdAndStatus(int reviewerid, int status)
   {
	   return reviewDAO.getReviewByReviewerIdAndStatus(reviewerid, status);
   }
   
   public UserEntity registerNewReviewer(UserEntity user) throws MailException,HibernateException{
   	
   	Set<Role> roleCollection = new HashSet<Role>();
       roleCollection.add(new Role(4,"ROLE_REVIEWER"));
       roleCollection.add(new Role(5,"ROLE_READER"));
       
   	user.setRoleCollection(roleCollection);
   	
   	user.setNumberPublishAvailable(0);
   	user.setNumberReviewAvailable(3);
   	String body="You are successfully registered, as a reviewer.\n"
   		 	+"Your password is: "+user.getPassword()+"\n"+"Regards,\n"+"teamo company";
   	emailUtils.sendEmail(user.getUsername(), "successfully registered", body);
   	 	
   	addUser(user);
   	
   	return user;
   }
   
   private void convertModelAndAddReview(ArticleReviewDetails review, ReviewForm rf)
   {
	  
	   review.setScore(rf.getScore());
	   review.setLevel(rf.getExpertise());
	   review.setSummary(rf.getSummary());
	   addCommentByType(review, rf.getCommentsCritisize(), ArticleReviewCommentDetails.COMMENT_TYPE_CRITICISM);
	   addCommentByType(review, rf.getCommentsSecret(), ArticleReviewCommentDetails.COMMENT_TYPE_SECRET);
	   addCommentByType(review, rf.getCommentsTypographic(), ArticleReviewCommentDetails.COMMENT_TYPE_SMALL_ERROR);
	   
	   reviewDAO.updateReview(review);
	   
   }
   
   private void addCommentByType(ArticleReviewDetails review, List<String> list, int commentType){
   	   
	   Set<String> collection = new HashSet<String>(list);
   	   Iterator it = collection.iterator();
   	   while(it.hasNext())
   	   {
   		   String str = (String) it.next();
   		   ArticleReviewCommentDetails comment = new ArticleReviewCommentDetails();
   		   comment.setComment(str);
   		   comment.setCommentType(commentType);
   		   comment.setReview(review); 	
   		   reviewDAO.addReviewComment(comment);
   	   }
   	  reviewDAO.updateReview(review);
   }
 
   // This method need to run automatically
	@Scheduled(fixedDelay = 1000*60*60*24)
	public void updateReviewStatusFromTempToReviewSubmited() 
	{ 
		String sevenDaysBefore = calc7daysBefore( new  GregorianCalendar());
		Set<ArticleReviewDetails> reviewCollection = reviewDAO.getReviewByTime(sevenDaysBefore);
		
		Iterator it = reviewCollection.iterator();
		while(it.hasNext())
		{
			ArticleReviewDetails review = (ArticleReviewDetails) it.next();
			review.setStatus(ArticleReviewDetails.SUBMITTED);
			reviewDAO.updateReview(review);
			
			String body="Point of your article\n";
	    		 	 
			
			Set<ArticleReviewCommentDetails> comments = review.getCommentCollection();
			Iterator itr = comments.iterator();
			while(itr.hasNext())
			{
				ArticleReviewCommentDetails comment = (ArticleReviewCommentDetails) it.next();
				body += comment.toString() + "\n";
			}
			body+= "Regards,\n"+"teamo company";
			String email = review.getArticle().getAuthor().getUsername();
	    	emailUtils.sendEmail(email, "article revising", body);
		}
    }	
	
	private String calc7daysBefore(GregorianCalendar calendar) 
	{  
        calendar.add(GregorianCalendar.DATE,  - 7 );
        return new  java.sql.Date(calendar.getTime().getTime()).toString();    
    } 
 
   public ArticleVersionDetails getCurrentArticleVersionDetails(Article article)
   { 
   	return articleDAO.getCurrentArticleVersionDetails(article);
   }
}
