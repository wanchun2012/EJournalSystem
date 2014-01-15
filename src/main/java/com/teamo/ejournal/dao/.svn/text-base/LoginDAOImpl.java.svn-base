package com.teamo.ejournal.dao;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teamo.ejournal.orm.Role;
import com.teamo.ejournal.orm.UserEntity;

@Transactional
@Repository
public class LoginDAOImpl {

	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(UserEntity user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public UserEntity findByName(String username) {
		logger.info("loading username: "+username);
		UserEntity user = null;
		try{
			user = (UserEntity) sessionFactory.getCurrentSession().createQuery(
					"from UserEntity where username='" + username+"'").uniqueResult();
		}catch (Exception e){
			logger.info("Exception: "+e);
		}
		return user;
	}
	
	public Set<Role> getSecurityRolesForUsername(String username) {
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession().createQuery(
		"select u from UserEntity u where u.username = " + username).uniqueResult();
		if (user!= null) {
			Set<Role> roles = (Set<Role>) user.getRoleCollection();
			if (roles != null && roles.size() > 0) {
				return roles;
			}
		}
		return null;
	}
}
