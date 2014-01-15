package com.teamo.ejournal.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

 

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamo.ejournal.orm.SubscribeMailingList;
import com.teamo.ejournal.orm.UserEntity;

@Repository("subscribeDAO")
public class SubscribeDAOImpl {
private static final Logger logger = LoggerFactory.getLogger(SubscribeDAOImpl.class);
	
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addSubscribe(SubscribeMailingList subscribe)  throws HibernateException {
     
        	 sessionFactory.getCurrentSession().save(subscribe);	
    }
    
    public void updateSubscribe(SubscribeMailingList subscribe) throws HibernateException {
    	 
    	    sessionFactory.getCurrentSession().update(subscribe);	 
    }
   
    public boolean existSubscribe(String email) throws HibernateException {
    	SubscribeMailingList subscribe = null;
	 
    	subscribe= (SubscribeMailingList)sessionFactory.getCurrentSession().createQuery(
					"from SubscribeMailingList where email='" + email+"'").uniqueResult();		 
	 
		return subscribe!=null;
    }
    
    public SubscribeMailingList getSubscribe(String email) throws HibernateException 
    {
     
    	SubscribeMailingList subscribe = null;
		 
    	subscribe = (SubscribeMailingList) sessionFactory.getCurrentSession().createQuery(
					"from SubscribeMailingList where email='" + email+"'").uniqueResult();
		 
		return subscribe;
     } 

    public Set<SubscribeMailingList> getNextEditonList()
    {
    	Set<SubscribeMailingList> subscribe = null;
		 
    	Query query =  sessionFactory.getCurrentSession().createQuery(
					"from SubscribeMailingList where subscribeNextEditon := check");
		query.setParameter("check", true);
		subscribe = new HashSet<SubscribeMailingList>(query.list());
		return subscribe;
    }
  /*
    public boolean getNumberOfEditors() throws HibernateException
    {
    	String[] role = {"ROLE_EDITOR"};
    	String hql = "select distinct a from UserEntity a " +
                "join a.roleCollection t " +
                "where t.name in (:role)";
    	Query query = sessionFactory.getCurrentSession().createQuery(hql);
    	query.setParameterList("role", role);
    	  
     List<UserEntity> users= query.list();
     //logger.info("---------------------"+users.size());
     return users.size()>1;
    }
    */
     
    public Set<SubscribeMailingList> getKeywordList(int keywordid)
    {
    	
    	Set<SubscribeMailingList> subscribe = null;
    	String hql = "select distinct a from SubscribeMailingList a " +
                "join a.subscribeKeywords t " +
                "where t.keyword_id =: keywordid";
    	Query query = sessionFactory.getCurrentSession().createQuery(hql);
    	query.setParameter("keywordid", keywordid);
    	subscribe = new HashSet<SubscribeMailingList>(query.list());
		return subscribe;
    }
  
}
