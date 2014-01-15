package com.teamo.ejournal.dao;

import java.util.Date;
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
import com.teamo.ejournal.orm.Role;
import com.teamo.ejournal.orm.UserEntity;

@Repository("userDAO")
public class UserDAOImpl {
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addUser(UserEntity user)  throws HibernateException {
     
        	 sessionFactory.getCurrentSession().save(user);
    	 
    	
    }
    public void updateUser(UserEntity user) throws HibernateException {
    	 
    	    sessionFactory.getCurrentSession().update(user);
    	 
    }
   
    public boolean existUser(String username) throws HibernateException {
    	UserEntity user = null;
	 
			user= (UserEntity)sessionFactory.getCurrentSession().createQuery(
					"from UserEntity where username='" + username+"'").uniqueResult();		 
	 
		return user!=null;
    }
    
    public UserEntity getUser(String username) throws HibernateException 
    {
     
    	UserEntity user = null;
		 
		user = (UserEntity) sessionFactory.getCurrentSession().createQuery(
					"from UserEntity where username='" + username+"'").uniqueResult();
		 
		return user;
     } 
 
    
    public UserEntity getUserById(int id) throws HibernateException 
    {
     
    	UserEntity user = null;
		 
		user = (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, id);
		 
		return user;
     } 
    
    public Set<UserEntity> getAllUsers() throws HibernateException
    {
    	Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserEntity");
	     
		return new HashSet<UserEntity>(query.list());
    }
    
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
    

    /*
    public void addContact(ArticleContactDetails contact) {
        sessionFactory.getCurrentSession().save(contact);
    }
    
    public boolean existContact(String email){
    	ArticleContactDetails contactDetail = null;
		try{
			contactDetail = (ArticleContactDetails) sessionFactory.getCurrentSession().createQuery(
					"from ArticleContactDetails where email='" + email+"'").uniqueResult();
		}catch (Exception e){
			logger.info("Exception: "+e);
		}
		return contactDetail!=null;
    }
     */
    
}
