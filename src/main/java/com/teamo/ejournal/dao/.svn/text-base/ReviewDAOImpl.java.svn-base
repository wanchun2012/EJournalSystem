package com.teamo.ejournal.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.ArticleReviewCommentDetails;
import com.teamo.ejournal.orm.ArticleReviewCommentResponseDetails;
import com.teamo.ejournal.orm.ArticleReviewDetails;

import org.joda.time.Days;
import org.joda.time.DateTime;

@Repository("reviewDAO")
public class ReviewDAOImpl {
	private static final Logger logger = LoggerFactory.getLogger(ReviewDAOImpl.class);
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addReview(ArticleReviewDetails review) throws HibernateException {
    	sessionFactory.getCurrentSession().save(review); 	 
    }
    
    public void updateReview(ArticleReviewDetails review) throws HibernateException {
		sessionFactory.getCurrentSession().update(review); 	 
    }
   
    public void addReviewComment(ArticleReviewCommentDetails comment)
    {
    	sessionFactory.getCurrentSession().save(comment); 	 
    }
    
    public void updateReviewComment(ArticleReviewCommentDetails comment)
    {
    	sessionFactory.getCurrentSession().update(comment); 	 
    }
    
    public void addReviewCommentResponse(ArticleReviewCommentResponseDetails response)
    {
    	sessionFactory.getCurrentSession().save(response); 	 
    }
    
    
    public ArticleReviewDetails getReviewByReviewerIdAndArticleId(int reviewerid, int articleid) throws HibernateException {
    	return (ArticleReviewDetails)sessionFactory.getCurrentSession().createQuery(
				"from ArticleReviewDetails where reviewer_id='" + reviewerid +"'"+" AND article_id='" + articleid + "'").uniqueResult();	 
    }
   /*
    public Set<ArticleReviewDetails> getTempReviewInitSevenDaysAgo(String sevenDaysBefore) throws HibernateException {
    	
    	return (Set<ArticleReviewDetails>)sessionFactory.getCurrentSession().createQuery(
				"from ArticleReviewDetails where status='" + ArticleReviewDetails.TEMP +"'"+" AND whenUpdated<'" + sevenDaysBefore + "'").uniqueResult();	 
    }
  */
    public boolean reviewRevisable(ArticleReviewDetails review)
    {
 
    	return Days.daysBetween(new DateTime(new Date()), new DateTime(review.getWhenUpdated())).getDays()<=7;
    }
    
    public Set<ArticleReviewDetails> getReviewByReviewerIdAndStatus(int reviewerid, int status) throws HibernateException {
    	Query query =  sessionFactory.getCurrentSession().createQuery(
				"from ArticleReviewDetails where reviewer_id='" + reviewerid +"'"+" AND status='" + status + "'"
						+" ORDER BY whenUpdated DESC");	
    	return new HashSet(query.list());
    }
 
    public Set<ArticleReviewDetails> getReviewByTime(String time) throws HibernateException
    {
 
		 Query query = sessionFactory.getCurrentSession().createQuery("from ArticleReivewDetails " +			 
				 "where whenUpdated < :time AND status := temp");
		 query.setParameter("time", time);
		 query.setParameter("temp", ArticleReviewDetails.TEMP);
	    //"where whenUpdated > '2012-05-03' AND whenUpdated < '2013-04-02'");
		 return new HashSet<ArticleReviewDetails>(query.list());
 
    }
  
}
