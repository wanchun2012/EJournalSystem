package com.teamo.ejournal.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
 
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.teamo.ejournal.core.util.EmailUtils;
import com.teamo.ejournal.dao.ArticleDAOImpl;
import com.teamo.ejournal.dao.SubscribeDAOImpl;
import com.teamo.ejournal.dao.UserDAOImpl;
import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.ArticleContactDetails;
import com.teamo.ejournal.orm.ArticleKeywordDetails;
import com.teamo.ejournal.orm.SubscribeMailingList;
import com.teamo.ejournal.orm.UserEntity;

@Service("readerService")
@Transactional
public class ReaderServiceImpl {
	
	@Autowired
    private ArticleDAOImpl articleDAO;
	
	@Autowired
    private SubscribeDAOImpl subscribeDAO;
	
	@Autowired
	private EmailUtils emailUtils;
	
	public Set<Article> displayAllArticlesForReader()
    {
    	return articleDAO.displayAllArticlesForReader();
    }
	
	// Reader Searching
	//It should also be possible to search for a particular paper by title (or a fragment thereof), 
	//or by author(s) name(s), 
	//or by date interval, 
	//or by a subject keyword search.
 
	// input fullname(firstname+" "+surname) 
	// return list of articles,(already contains duplicated name cases)
	public Set<Article> searchArticlesByAuthor(String fullname)
    {
    	
    	Set<ArticleContactDetails> contactCollection = articleDAO.searchArticlesByAuthor(fullname);
    	Set<Article> resultCollection = new HashSet<Article>();
    	
    	Iterator it = contactCollection.iterator();
        while(it.hasNext())
        {  	
        	ArticleContactDetails contact = (ArticleContactDetails) it.next();
        	Collection<Article> articleCollection = contact.getContactCollection();
        	 
	        Iterator ita = articleCollection.iterator();
	        while(ita.hasNext())
	        {
	        	Article article = (Article) ita.next();
	        	if(article.getStatus()==Article.PUBLISHED)
	        	{
	        
	        	  if(!resultCollection.contains(article))
	        	  {
	        		  resultCollection.add(article);
	        	  }
	        	}
	        }     	 
        }
        return resultCollection;
    }
	
	public Set<Article> searchArticlesByKeyword(String word)
    {
		ArticleKeywordDetails keyword = articleDAO.searchArticlesByKeyword(word);
    	Set<Article> resultCollection = new HashSet<Article>();
    	
    	Collection<Article> articleCollection = keyword.getKeywordCollection();
        	 
	    Iterator ita = articleCollection.iterator();
	    while(ita.hasNext())
	    {
	      Article article = (Article) ita.next();
	      if(article.getStatus()==Article.PUBLISHED)
	      {
	        if(!resultCollection.contains(article))
	        {
	        	resultCollection.add(article);
	        }
	      }
	    }     	 
     
        return resultCollection;
    }
	
	public Set<Article> searchArticlesByTitle(String title)
    {
		Set<Article> articleCollection = articleDAO.searchArticlesByTitle(title);
    	Set<Article> resultCollection = new HashSet<Article>();
    		 
	    Iterator ita = articleCollection.iterator();
	    while(ita.hasNext())
	    {
	      Article article = (Article) ita.next();
	      if(article.getStatus()==Article.PUBLISHED)
	      {
	        if(!resultCollection.contains(article))
	        {
	        	resultCollection.add(article);
	        }
	      }
	    }     	 
     
        return resultCollection;
    }
    //startTime, and endTime format::2012-05-03
	public Set<Article> searchArticlesByTimeInterval(String startTime, String endTime)
	{
		Set<Article> articleCollection = articleDAO.searchArticlesByTimeInterval(startTime, endTime);
    	Set<Article> resultCollection = new HashSet<Article>();
        
	    Iterator ita = articleCollection.iterator();
	    while(ita.hasNext())
	    {
	      Article article = (Article) ita.next();
	      if(article.getStatus()==Article.PUBLISHED)
	      {
	        if(!resultCollection.contains(article))
	        {
	        	resultCollection.add(article);
	        }
	      }
	    }     	 
      
        return resultCollection;
	}
	
    public boolean subscribeNextEditions(String email)
    {
    	// return true if user hasnt subscribe next edition, else show message to user
    	// already subscribe next edition
    	
    	if(subscribeDAO.existSubscribe(email))
    	{
    		
    		SubscribeMailingList subscribe = subscribeDAO.getSubscribe(email);
    		
    		if(!subscribe.getSubscribeNextEditions())
    		{
	    		subscribe.setSubscribeNextEditions(true);
	    		subscribeDAO.updateSubscribe(subscribe);
	    		sendSubscribeEmail(subscribe, "subscribe next edition", null);
	    		return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    	{
    		SubscribeMailingList subscribe = new SubscribeMailingList();
    		subscribe.setEmail(email);
    		subscribe.setSubscribeNextEditions(true);
    		subscribeDAO.addSubscribe(subscribe);
    		sendSubscribeEmail(subscribe, "subscribe next edition", null);
    		return true;
    	}
    	
    	
    }
    
    public int subscribeKeywords(String email, String keyword)
    {
    	// 0 success, 1 already subscribed, 2 keyword not in db
    	// already subscribe next edition
    	int result = -1;
    	if(subscribeDAO.existSubscribe(email))
    	{
    		
    		SubscribeMailingList subscribe = subscribeDAO.getSubscribe(email);
    		
    		result = updateKeywordsCollection(subscribe, keyword); 		
	    	if(result == 0)
	    		sendSubscribeEmail(subscribe, "subscribe keyword", keyword);
	    	
	    	return result;
    	 
    	}
    	else
    	{
    		SubscribeMailingList subscribe = new SubscribeMailingList();
    		subscribe.setEmail(email);  		
    		subscribe.setSubscribeNextEditions(false);
    		subscribeDAO.addSubscribe(subscribe);
    		
    		result = updateKeywordsCollection(subscribe, keyword);
    		if(result == 0)
    			sendSubscribeEmail(subscribe, "subscribe keyword", keyword);
    		
    		return result;
    	}
    	
     
      
    }
    
    public int updateKeywordsCollection(SubscribeMailingList subscribe, String keyword){
    		
    	Set<ArticleKeywordDetails> keywordCollection = subscribe.getSubscribeKeywords();
    	if(articleDAO.existKeyword(keyword))
    	{ 	
    		if(keywordCollection.contains(articleDAO.getExistKeyword(keyword)))
    		{
    			return 1; // already exist in keywordCollection
    		}
    		else
    		{
	    		keywordCollection.add((articleDAO.getExistKeyword(keyword)));
	    		subscribe.setSubscribeKeywords(keywordCollection);
	    		subscribeDAO.updateSubscribe(subscribe);
	    		return 0;
    		}
		}
    	else
    	{
    		return 2; // doesnt exist in keyword table
    	}
        
    }
    
    public void sendSubscribeEmail(SubscribeMailingList subscribe, String subscribletype, String keyword)
    {
    	String body="You are successfully " + subscribletype +": "+keyword
    		 	+"\n"+"Regards,\n"+"teamo company";
    	emailUtils.sendEmail(subscribe.getEmail(), subscribletype, body);
    }
    
}
