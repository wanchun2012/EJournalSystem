package com.teamo.ejournal.service;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.teamo.ejournal.dao.ArticleDAOImpl;
 
import com.teamo.ejournal.dao.UserDAOImpl;
import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.ArticleReviewCommentDetails;
import com.teamo.ejournal.orm.ArticleReviewDetails;
import com.teamo.ejournal.orm.ArticleVersionDetails;
import com.teamo.ejournal.orm.UserEntity;

@Service("authorService")
@Transactional
public class AuthorServiceImpl extends UserServiceImpl {
	
	@Autowired
    private ArticleDAOImpl articleDAO;
	@Autowired
	private UserDAOImpl userDAO;
	
	// method in articleDAO is in comment, change them and call the method
    public Set<Article> displayArticleForAuthorSpecifyByStatus(int status, String username)
    {
    	Set<Article> resultCollection = new HashSet<Article>();
    	
    	UserEntity user = userDAO.getUser(username);    	
    	Set<Article> articleCollection = user.getArticleCollection();
    	
    	Iterator it = articleCollection.iterator();
    	while(it.hasNext())
    	{
    		Article article = (Article) it.next();
    		if(article.getStatus()==status)
    		{
    			resultCollection.add(article);
    		}
    	}
    	
    	return resultCollection;
    }
    
    public Set<Article> displayAllArticlesForAuthor(String username) 
    {
    	int authorid = getUser(username).getId();
    	return articleDAO.displayAllArticlesForAuthor(authorid);
    }
    
    public ArticleVersionDetails getCurrentArticleVersionDetails(Article article)
    { 
    	return articleDAO.getCurrentArticleVersionDetails(article);
    } 
    
 // This method need to run automatically
 	@Scheduled(fixedDelay = 1000*60*60*24)
 	public void updateArticleStatusFromReviewOneToReviewTwo() 
 	{ 
 		 
 		Set<Article> articleCollection = articleDAO.getArticlesByStatus(Article.REVIEW_1);
 		
 		Iterator it = articleCollection.iterator();
 		while(it.hasNext())
 		{
 			Article article = (Article) it.next();
 		    int reviewSubmitNumber = 0;
 		    Set<ArticleReviewDetails> reviewCollection = article.getReviewCollection();
 		    Iterator itr = reviewCollection.iterator();
 		    
 		    while(itr.hasNext())
 		    {
 		    	ArticleReviewDetails review = (ArticleReviewDetails) itr.next();
 		    	if(review.getStatus()==ArticleReviewDetails.SUBMITTED)
 		    	{
 		    		reviewSubmitNumber++;
 		    	}
 		    }
 		    
 		    if(reviewSubmitNumber==3)
 		    {
 				article.setStatus(Article.REVIEW_2);
 		    }
 		}
     }	
 	
}