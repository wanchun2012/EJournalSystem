package com.teamo.ejournal.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.teamo.ejournal.orm.Journal;
import com.teamo.ejournal.orm.JournalSetting;
import com.teamo.ejournal.orm.UserEntity;

@Repository("journalDAO")
public class JournalDAOImpl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleDAOImpl.class);
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addJournalSetting(JournalSetting setting) throws HibernateException {
    		sessionFactory.getCurrentSession().save(setting); 	 
    }
    
    public void updateJournalSetting(JournalSetting setting) throws HibernateException {
		sessionFactory.getCurrentSession().update(setting); 	 
    }
    
    public void addJournal(Journal journal) throws HibernateException {
		sessionFactory.getCurrentSession().save(journal); 	 
    }
    
    public void updateJournal(Journal journal) throws HibernateException {
		sessionFactory.getCurrentSession().update(journal); 	 
    }
    
    public JournalSetting getCurrentJournalSetting() throws HibernateException{
    	JournalSetting js = null;
    	
    	js = (JournalSetting) sessionFactory.getCurrentSession().createQuery(
					"from JournalSetting where id='1'").uniqueResult();
		
		return js;
    }
    
    public Journal getCurrentJournal() throws HibernateException{
    	List<Journal> journal = null;
    	
    	journal = (List<Journal>) sessionFactory.getCurrentSession().createQuery(
					"from Journal ORDER BY whenCreated DESC").list();
		
		return journal.get(0);
    }
}