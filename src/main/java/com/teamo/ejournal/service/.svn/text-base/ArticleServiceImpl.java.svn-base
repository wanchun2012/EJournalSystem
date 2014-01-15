package com.teamo.ejournal.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamo.ejournal.core.model.ArticleUpload;
import com.teamo.ejournal.core.model.Author;
import com.teamo.ejournal.core.util.UploadUtils;
import com.teamo.ejournal.dao.ArticleDAOImpl;
import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.ArticleContactDetails;
import com.teamo.ejournal.orm.ArticleKeywordDetails;
import com.teamo.ejournal.orm.ArticleVersionDetails;
import com.teamo.ejournal.orm.UserEntity;

@Service("articleService")
@Transactional
public class ArticleServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Autowired
    private ArticleDAOImpl articleDAO;
     
    public void addArticle(Article article) throws HibernateException,ConstraintViolationException {
        articleDAO.addArticle(article);
    }
    
    public void addContact(ArticleContactDetails contact){
    	articleDAO.addContact(contact);
    }
    public void addKeyword(ArticleKeywordDetails keyword){
    	articleDAO.addKeyword(keyword);
    }
    public ArticleKeywordDetails getExistKeyword(String keyword){
    	return articleDAO.getExistKeyword(keyword);
    }
    public void addVersion(ArticleVersionDetails version){
    	articleDAO.addVersion(version);
    }
    public boolean existContact(String email){
    	return articleDAO.existContact(email);
    }
    public ArticleContactDetails getExistContact(String email){
    	return articleDAO.getExistContact(email);
    }
    public boolean existKeyword(String keyword){
    	return articleDAO.existKeyword(keyword);
    }
    public boolean existVersion(String filePath){
    	return articleDAO.existVersion(filePath);
    }
    public void updateArticle(Article article)
    {
    	articleDAO.updateArticle(article);
    }
    public Article getArticle(int id){
    	return articleDAO.getArticleById(id);
    }
    
    public void updateArticleUploaded(UserEntity user, boolean isAuth, Article article, ArticleUpload au) throws HibernateException,ConstraintViolationException{
    	
    	int versionStatus = ArticleVersionDetails.INIT;
    	if (isAuth) versionStatus = ArticleVersionDetails.INIT;
    	
    	updateVersion(article,versionStatus);
    	
    	article.setAuthor(user);
    	//###article.setJournalid(1);
    	article.setNumberReviewed(0);
    	article.setStatus(versionStatus);
        article.setWhenUpdated(new Date());
        article.setTitle(au.getTitle());
        article.setArticleAbstract(au.getPaperAbstract());
        article.setAuthor(user);
        addArticle(article);
        article.setContactCollection(createAndGetContacts(au));
        article.setKeywordCollection(createAndGetKeywords(au));

        
    }
    
    public Set<ArticleContactDetails> createAndGetContacts(ArticleUpload au){
    	
    	Set<ArticleContactDetails> contactCollection = new HashSet<ArticleContactDetails>();
    	
    	logger.info("Getting contacts...");
    	
    	for (Author details:au.getAuthors()) {
    		logger.info("author: "+details);
    		ArticleContactDetails acd = getExistContact(details.getEmail());
    		if(acd == null){
        		acd = new ArticleContactDetails();
    			acd.setFirstname(details.getFirstname());
    			acd.setSurname(details.getSecondname());
    			acd.setEmail(details.getEmail());
    			acd.setAffiliation(details.getAffiliation());
    			addContact(acd);
    		}
    	    contactCollection.add(acd);
		}
    	
    	return contactCollection;
    }
    
    public Set<ArticleKeywordDetails> createAndGetKeywords(ArticleUpload au){
    	
    	Set<ArticleKeywordDetails> keywordCollection = new HashSet<ArticleKeywordDetails>();
    	logger.info("keyword: "+keywordCollection.size());
    	for (String keyword:au.getKeywords()) {
    		ArticleKeywordDetails akd = getExistKeyword(keyword);
    		if(akd == null){
    			akd = new ArticleKeywordDetails();
    			akd.setKeyword(keyword);
    			addKeyword(akd);
    		}
    		keywordCollection.add(akd);
		}
    	
    	return keywordCollection;
    }
    
    public int getNextVersionNumber(Article article){
    	if (article.getVersionCollection() == null) return 1;
    	else {
    		int greater = 0;
    		for (ArticleVersionDetails avd : article.getVersionCollection()) {
    			if (avd.getVersion() > greater) greater = avd.getVersion();
    		}
    		return greater+1;
		}
    }
    
    public void updateVersion(Article article, int versionType){
    	
    	if(existVersion(article.lastVersionURL)) return;

    	ArticleVersionDetails version = new ArticleVersionDetails();
    	version.setFilePath(article.lastVersionURL);
    	version.setWhenCreated(new Date());
    	version.setVersion(versionType);
    	version.setArticle(article);
    	addVersion(version);
    	
    	/*
    	Set<ArticleVersionDetails> versionCollection = article.getVersionCollection();
    	if (versionCollection == null) versionCollection = new HashSet<ArticleVersionDetails>();
    	versionCollection.add(version);
    	article.setVersionCollection(versionCollection);
    	*/
    }
}