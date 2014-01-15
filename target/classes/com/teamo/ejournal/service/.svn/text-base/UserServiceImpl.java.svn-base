package com.teamo.ejournal.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Iterator;
 

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.teamo.ejournal.core.ReviewerController;
import com.teamo.ejournal.core.util.EmailUtils;
import com.teamo.ejournal.dao.UserDAOImpl;
import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.Role;
import com.teamo.ejournal.orm.UserEntity;

@Service("userService")
@Transactional
public class UserServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
    private UserDAOImpl userDAO;
	
	@Autowired
	private EmailUtils emailUtils;
     
    public void addUser(UserEntity user) throws HibernateException {
        userDAO.addUser(user);
    }
    public void updateUser(UserEntity user){
    	userDAO.updateUser(user);
    }
    public boolean existUser(String username) {
        return userDAO.existUser(username);
    }
    
    public UserEntity getUser(String username) {
    	return userDAO.getUser(username);
    }
    
    public UserEntity getUserById(int id)
    {
    	return  userDAO.getUserById(id);
    }
    
    public boolean registerNewTempUserIfDoesntExist(String email) throws MailException,HibernateException{
    	
    	logger.info("register temp user if doesnt exist");
    	
    	if(!existUser(email)){
    		try{
    			logger.info("user doesnt exist.. trying to create temp user...");
    			registerNewTempUser(email);
    		}catch(MailException mex){
    			mex.printStackTrace();
    			return false;
    		}
		}
    	
    	logger.info("returning..");
    	
    	return true;
    }
    
    public UserEntity registerNewTempUser(String email) throws MailException,HibernateException{
    	UserEntity user = new UserEntity();
    	user.setUsername(email);
    	logger.info("trying to register new temp user...");
    	return registerNewTempUser(user);
    }
    
    public UserEntity registerNewTempUser(UserEntity user) throws MailException,HibernateException{
    	
    	Set<Role> roleCollection = new HashSet<Role>();
        roleCollection.add(new Role(6,"ROLE_TEMP"));
        
    	user.setRoleCollection(roleCollection);
    	
    	String randomPassword = UUID.randomUUID().toString().substring(0,8);
    	user.setPassword(randomPassword);
    	
    	logger.info("sending email to new temp user...");
    	user.setNumberPublishAvailable(0);
    	user.setNumberReviewAvailable(3);
    	String body="You are successfully registered, please login and change your password in 24 hours.\n"
    		 	+"Your password is: "+randomPassword+"\n"+"Regards,\n"+"teamo company";
    	emailUtils.sendEmail(user.getUsername(), "successfully registered", body);
    	
    	logger.info("saving new temp user...");
    	
    	addUser(user);
    	
    	return user;
    }
    
    public void registerTempUserAsReaderWithNewPassword(String username,String newPw){
    	
    	UserEntity user = getUser(username);
    	
    	user.setPassword(newPw);
    	
    	Set<Role> roleCollection = new HashSet<Role>();
    	roleCollection.add(new Role(5,"ROLE_READER"));
    	user.setRoleCollection(roleCollection);
    	
    	updateUser(user);
    }
    
    public void updateRolesForArticleUploader(UserEntity user){
    	Set<Role> roleCollection = user.getRoleCollection();
   	 
    	if (roleCollection == null) roleCollection = new HashSet<Role>();
    	
    	Role author = new Role(3,"ROLE_AUTHOR");
    	Role reviewer = new Role(4,"ROLE_REVIEWER");
    	if (!roleCollection.contains(author)){
    		roleCollection.add(author);
    	}
    	if (!roleCollection.contains(reviewer)){
    		roleCollection.add(reviewer);
    	}
    	user.setRoleCollection(roleCollection);
    	
    	updateUser(user);
    }
    
    public void UpdateRoleWhenEditorRetired(UserEntity user)
    {
    	Set<Role> roleCollection = new HashSet<Role>();
    	roleCollection.add(new Role(5,"ROLE_READER"));
    	user.setRoleCollection(roleCollection);
    	
    	updateUser(user);
    	 
    }
    
    public void UpdateRoleWhenEditorAppointed(UserEntity user)
    {
    	Set<Role> roleCollection = new HashSet<Role>();
    	roleCollection.add(new Role(2,"ROLE_EDITOR"));
    	user.setRoleCollection(roleCollection);
    	updateUser(user);
    	 
    }
    public void blockUser(UserEntity user)
    {
    	Set<Role> roleCollection = new HashSet<Role>();
    	 
    	roleCollection.add(new Role(7,"ROLE_BLOCK"));
    	 
    	user.setRoleCollection(roleCollection);
    	
    	updateUser(user);
    }
    
    public boolean isAuthor(String username)
    {
    	UserEntity user = userDAO.getUser(username);
    	Set<Role> roleCollection = user.getRoleCollection();
    	
    	Iterator it = roleCollection.iterator();
    	while(it.hasNext())
    	{
    		Role role = (Role)it.next();
    		if(role.getName().equals("ROLE_AUTHOR"))
    		{
    			return true;
    		}
    	}
    	return false;
    	
    }
    
 
    /*
    public void addContact(ArticleContactDetails contact){
    	userDAO.addContact(contact);
    }
    
    public boolean existContact(String email){
    	return userDAO.existContact(email);
    }
    */
}
