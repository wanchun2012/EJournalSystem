package com.teamo.ejournal.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.ArticleContactDetails;
import com.teamo.ejournal.orm.ArticleKeywordDetails;
import com.teamo.ejournal.orm.ArticleVersionDetails;
import com.teamo.ejournal.orm.UserEntity;

@Repository("articleDAO")
public class ArticleDAOImpl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleDAOImpl.class);
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addArticle(Article article) throws HibernateException,ConstraintViolationException {
    		sessionFactory.getCurrentSession().save(article); 	 
    }
    public void addContact(ArticleContactDetails contact) throws HibernateException {
     
    		sessionFactory.getCurrentSession().save(contact); 	 
    }
    public void addKeyword(ArticleKeywordDetails keyword)  throws HibernateException{
     
    		sessionFactory.getCurrentSession().save(keyword);
    	 
    }
    public void addVersion(ArticleVersionDetails version)  throws HibernateException{
    	 
    		sessionFactory.getCurrentSession().save(version);
    	 
    }
    
    public boolean existKeyword(String keyword) throws HibernateException {
    	ArticleKeywordDetails keywordDetail = null;
	 
		keywordDetail = (ArticleKeywordDetails) sessionFactory.getCurrentSession().createQuery(
					"from ArticleKeywordDetails where keyword='" + keyword+"'").uniqueResult();
		 
		return keywordDetail!=null;
    }
    public ArticleKeywordDetails getExistKeyword(String keyword)  throws HibernateException {
    	ArticleKeywordDetails keywordDetail = null;
	 
		keywordDetail = (ArticleKeywordDetails) sessionFactory.getCurrentSession().createQuery(
					"from ArticleKeywordDetails where keyword='" + keyword+"'").uniqueResult();
		 
		return keywordDetail;
    }
    
    public boolean existContact(String email) throws HibernateException{
    	ArticleContactDetails contactDetail = null;
	 
		contactDetail = (ArticleContactDetails) sessionFactory.getCurrentSession().createQuery(
					"from ArticleContactDetails where email='" + email+"'").uniqueResult();
		 
		return contactDetail!=null;
    }
    public ArticleContactDetails getExistContact(String email) throws HibernateException{
    	ArticleContactDetails contactDetail = null;
    	
		contactDetail = (ArticleContactDetails) sessionFactory.getCurrentSession().createQuery(
					"from ArticleContactDetails where email='" + email+"'").uniqueResult();
		
		return contactDetail;
    }
    public boolean existVersion(String filePath)  throws HibernateException{
    	ArticleVersionDetails versionDetail = null;
	 
		versionDetail = (ArticleVersionDetails) sessionFactory.getCurrentSession().createQuery(
					"from ArticleVersionDetails where filePath='" + filePath+"'").uniqueResult();
		 
		return versionDetail!=null;
    }
    
    public void updateArticle(Article article) throws HibernateException{
    	sessionFactory.getCurrentSession().update(article);
    }
    /*
    @SuppressWarnings("unchecked")
	public Set<Article> displayArticleForAuthorSpecifyByStatus(int status, int authorid) throws HibernateException
    {  
	 
			return (Set<Article>)sessionFactory.getCurrentSession().createQuery(
					"from Article where status='" + status+"'"+" AND authorid='" + authorid + "'" +" ORDER BY whenUpdated DESC").list();
		 
		
		 
		 //comments for get version details:
		 //we dont change version status from temp to init after change article status from temp to init
		 //dont save duplicated pdf for temp and init
		 //Arti
		 //Article.INIT = ArticleVersionDetails.INIT
		 //Article.REVISED_1 = ArticleVersionDetails.INIT
		 //Article.REVISED_2 = ArticleVersionDetails.REVISED
		 //Article.FINISH = ArticleVersionDetails.FINAL
		 //Article.PUBLISHED = ArticleVersionDetails.FINAL
		 //Article.REJECTED = ArticleVersionDetails.FINAL
 
    }
    */
    @SuppressWarnings("unchecked")
	public Set<Article> displayAllArticlesForAuthor(int authorid) throws HibernateException
    {
   
    	    Query query = sessionFactory.getCurrentSession().createQuery(
					"from Article where author_id='" + authorid+"'"+" ORDER BY whenUpdated DESC");
    	     
			return new HashSet<Article>(query.list());
		 
     
    	// comments for display article for editer, depend on article status, 
    	// and can view different version by getVersionCollection and see different version for the article
    	 
    }
    public Set<Article> displayAllArticles() throws HibernateException {
    	Set<Article> result = null;
    	Query query = sessionFactory.getCurrentSession().createQuery("from Article ORDER BY whenUpdated DESC");
		result = new HashSet(query.list());
		return result;
    }
    
    @SuppressWarnings("unchecked")
	public Set<Article> displayArticleForReviewer(int limit) throws HibernateException
    {
    	 
	    Query query = sessionFactory.getCurrentSession().createQuery(
				"from Article where status='" + Article.INIT+"'"+" ORDER BY whenUpdated ASC");
	    query.setMaxResults(limit);
		return new HashSet<Article>(query.list());
    	 
    	// comments for display article for reviewer coz reviewer has limitation to see all the
    	// paper, then set display limit for display e.g. 100
    	 
    }
    
	public Set<Article> displayAllArticlesForReader()  throws HibernateException
    {
     
	    Query query = sessionFactory.getCurrentSession().createQuery(
				"from Article where status='" + Article.PUBLISHED+"'"+" ORDER BY whenUpdated DESC");
	   
		return  new HashSet<Article>(query.list());
		 
    	 
    	 // all the articles for reader, only for article.Published
    	 
    }
	
	public Set<Article> getArticlesByStatus(int status)  throws HibernateException
    {
     
	    Query query = sessionFactory.getCurrentSession().createQuery(
				"from Article where status='" + status +"'"+" ORDER BY whenUpdated DESC");
	   
		return  new HashSet<Article>(query.list());
		 
    	 
    	 // all the articles for reader, only for article.Published
    	 
    }
	
	
	public Set<ArticleContactDetails> searchArticlesByAuthor(String fullname) throws HibernateException
    {
 
		 Query query = sessionFactory.getCurrentSession().createQuery("from ArticleContactDetails " +
				"where concat(firstname, ' ',surname ) = '" + fullname + "'");
		 return new HashSet<ArticleContactDetails>(query.list());
		 	 
		 
    }
	
	public ArticleKeywordDetails searchArticlesByKeyword(String keyword) throws HibernateException
    {
 
		 Query query = sessionFactory.getCurrentSession().createQuery("from ArticleKeywordDetails " +
				"where keyword = '" + keyword + "'");
		 return (ArticleKeywordDetails)query.uniqueResult();
	 
    }
    
	public Set<Article> searchArticlesByTitle(String title) throws HibernateException
    {
    
		 Query query = sessionFactory.getCurrentSession().createQuery("from Article " +
				"where title like '%" + title + "%'");
		 return new HashSet<Article>(query.list());
		 	 
		 
    }
	
	public Set<Article> searchArticlesByTimeInterval(String startTime, String endTime) throws HibernateException
    {
 
		 Query query = sessionFactory.getCurrentSession().createQuery("from Article " +			 
				 "where whenUpdated > '" + startTime + "' AND whenUpdated < '" + endTime + "'");
	    //"where whenUpdated > '2012-05-03' AND whenUpdated < '2013-04-02'");
		 return new HashSet<Article>(query.list());
 
    }
	
    @SuppressWarnings("unchecked")
	public Set<Article> displayArticleForEditor(int status) throws HibernateException
    {
   
    	    Query query = sessionFactory.getCurrentSession().createQuery(
					"from Article where status='" + status+"'"+" ORDER BY whenUpdated DESC");
    	     
			return new HashSet<Article>(query.list());
		 
     
    	// comments for display article for editer, depend on article status, 
    	// and can view different version by getVersionCollection and see different version for the article
    	 
    }
   
 
    public ArticleVersionDetails getCurrentArticleVersionDetails(Article article) throws HibernateException
    {
    	int articleStatus = article.getStatus();
    	Set<ArticleVersionDetails> versionCollection = article.getVersionCollection();
    	int versionStatus;
    	
    	if(articleStatus <= Article.INIT)
    	{
    		versionStatus = articleStatus;
    	}
    	else if(articleStatus==Article.REVIEW_1) // under review state one
    	{
    		versionStatus = ArticleVersionDetails.INIT;
    	}
    	else if(articleStatus==Article.REVIEW_2) // under review state two
    	{
    		versionStatus = ArticleVersionDetails.RIVISED;
    	}
    	else
    	{
    		versionStatus = ArticleVersionDetails.FINAL;
    	}
    	int versionId = -1;
        
    	
    	Iterator<ArticleVersionDetails> it = versionCollection.iterator();
    	while (it.hasNext()) {
        	ArticleVersionDetails version = it.next();
        	if(version.getVersion() == versionStatus)
        	{
                 versionId = version.getId();
        	}
        } 
    	
     
		return (ArticleVersionDetails)sessionFactory.getCurrentSession().createQuery(
				"from ArticleVersionDetails where id='" + versionId+"'").uniqueResult();
	 
    }
    
    public Article getArticleById(int id) throws HibernateException 
    {
     
    	Article article = null;
		 
    	article = (Article) sessionFactory.getCurrentSession().get(Article.class, id);
		 
		return article;
     } 
    
    public Set<Article> getReviewCollectionArticlesByIds(Set<Integer> articleidSet) throws HibernateException 
    {
     
    	Set<Article> resultCollection = new HashSet<Article>();
    	
    	Iterator it = articleidSet.iterator();
    	while(it.hasNext())
    	{
    		int id = (Integer) it.next();
    		Article article = null;
		 
    		article = (Article) sessionFactory.getCurrentSession().get(Article.class, id);
    		resultCollection.add(article);
    	}
		return resultCollection;
     } 
    
    
    
}
