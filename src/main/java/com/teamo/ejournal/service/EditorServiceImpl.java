package com.teamo.ejournal.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
 

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.teamo.ejournal.dao.ArticleDAOImpl;
import com.teamo.ejournal.dao.JournalDAOImpl;
import com.teamo.ejournal.dao.SubscribeDAOImpl;
import com.teamo.ejournal.dao.UserDAOImpl;
import com.teamo.ejournal.orm.Article;
import com.teamo.ejournal.orm.ArticleKeywordDetails;
import com.teamo.ejournal.orm.ArticleVersionDetails;
import com.teamo.ejournal.orm.Journal;
import com.teamo.ejournal.orm.JournalSetting;
import com.teamo.ejournal.orm.SubscribeMailingList;
import com.teamo.ejournal.orm.UserEntity;
import com.teamo.ejournal.orm.Role;
import com.teamo.ejournal.core.model.JournalSettingsForm;
import com.teamo.ejournal.core.util.EmailUtils;

@Service("editorService")
@Transactional
public class EditorServiceImpl extends UserServiceImpl {
	
	@Autowired
    private ArticleDAOImpl articleDAO;
	
	@Autowired
    private UserDAOImpl userDAO;
	
	@Autowired
    private SubscribeDAOImpl subscribeDAO;
	
	@Autowired
    private JournalDAOImpl journalDAO;
	
	@Autowired
	private EmailUtils emailUtils;
	
	// method in articleDAO is in comment, change them and call the method
    public Set<Article> displayArticleForEditor(int status)
    {
    	return articleDAO.displayArticleForEditor(status);
    }

    public Set<Article> displayAllArticleForEditor()
    {
    	return articleDAO.displayAllArticles();
    }
    public ArticleVersionDetails getCurrentArticleVersionDetails(Article article)
    { 
    	return articleDAO.getCurrentArticleVersionDetails(article);
    }
    
    // list of paper waiting to be published
    public Set<Article> displayArticlesNeedPublishing()
    {
    	return articleDAO.displayArticleForEditor(Article.WAITING_PUBLISHED);
    }
    // display article info
   
    // publish article
    public void publishArticle(int articleid) throws HibernateException//articleid, // last journal
    {
    
    	Article article = articleDAO.getArticleById(articleid);
    	//if(article.getStatus()==Article.WAITING_PUBLISHED)
    	//{
    	article.setStatus(Article.PUBLISHED);
    	article.setJournal(getCurrentJournal());
    	
    	articleDAO.updateArticle(article);
    	
    	UserEntity author = article.getAuthor();
    	author.setNumberPublishAvailable(author.getNumberPublishAvailable()-3);
    	updateUser(author);
    	  
    	Set<ArticleKeywordDetails> keywordCollection = article.getKeywordCollection();
    	Iterator it = keywordCollection.iterator();
    	while(it.hasNext())
    	{
    		ArticleKeywordDetails keyword = (ArticleKeywordDetails) it.next();
    		Set<SubscribeMailingList> s = subscribeDAO.getKeywordList(keyword.getId());
    		
    		Iterator its = keywordCollection.iterator();
    		while(its.hasNext())
    		{
    			SubscribeMailingList sends = (SubscribeMailingList) its.next();
    			String body="Article: .\n"
    	    		 	+article.toString()+"\n"+"Regards,\n"+"teamo company";
    	    	emailUtils.sendEmail(s.toString(), "Article notification", body);
    		}
    	}
     
    	//}
    }
    
    // reject article
    public void rejectArticle(int articleid) //articleid
    {
    	Article article = articleDAO.getArticleById(articleid);
    	article.setStatus(Article.REJECTED);
    	articleDAO.updateArticle(article);
    }
    
    // list of users
    public Set<UserEntity> displayAllUsers()
    {
    	return userDAO.getAllUsers();
    }
    // retire editor
    public boolean selfRetired(String username)
    {
    	try {
    		if(userDAO.getNumberOfEditors())
        	{
        		UserEntity user = getUser(username);
        		Set<Role> roleCollection = user.getRoleCollection();
        		Set<Role> updatedCollection = new HashSet<Role>();
        		Iterator it = roleCollection.iterator();
        		while(it.hasNext())
        		{
        			Role role = (Role) it.next();
        			if(!role.getName().equals("ROLE_EDITOR"))
        			{
        				updatedCollection.add(role);
        			}
        		}
        		user.setRoleCollection(updatedCollection);
        		updateUser(user);
        	} else return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	
    	return true;
    }
    // add editor
    public void appointEditor(String username)
    {
    	UserEntity user = getUser(username);
    	Set<Role> roleCollection = user.getRoleCollection();
    	roleCollection.add(new Role(2,"ROLE_EDITOR"));
    	user.setRoleCollection(roleCollection);
    	updateUser(user);
    }
    
    public UserEntity registerNewEditor(String email) throws MailException,HibernateException{
    	UserEntity user = new UserEntity();
    	user.setUsername(email);
    	return registerNewEditor(user);
    }
    
    // add new user as editor
    public UserEntity registerNewEditor(UserEntity user) throws MailException,HibernateException{
    	
    	Set<Role> roleCollection = new HashSet<Role>();
        roleCollection.add(new Role(2,"ROLE_EDITOR"));
        roleCollection.add(new Role(5,"ROLE_READER"));
        
    	user.setRoleCollection(roleCollection);
    	
    	String randomPassword = UUID.randomUUID().toString().substring(0,8);
    	user.setPassword(randomPassword);
    	 
    	user.setNumberPublishAvailable(0);
    	user.setNumberReviewAvailable(3);
    	String body="You are successfully registered, as an editor.\n"
    		 	+"Your password is: "+randomPassword+"\n"+"Regards,\n"+"teamo company";
    	emailUtils.sendEmail(user.getUsername(), "successfully registered", body);
    	 	
    	addUser(user);
    	
    	return user;
    }
    
    // add journal settings
    public void updateJournalSetting(JournalSettingsForm journalSettingsForm)
    {
    	JournalSetting setting = getCurrentJournalSetting();
		setting.setTitle(journalSettingsForm.getJournalTitle());
		setting.setAcademicGoals(journalSettingsForm.getAimsAndGoals());
    	setting.setWhenUpdated(new Date());
    	journalDAO.updateJournalSetting(setting);
    }
    
    public Journal getCurrentJournal()
    {
    	Date dateNow = new Date();
    	
    	Journal journal = journalDAO.getCurrentJournal();
    	Date dateJournal = journal.getWhenCreated();
    	
    	final String FORMAT = "yyyy-MM-dd";
    	SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
    	
    	String strNow = sdf.format(dateNow);
    	String strJournal = sdf.format(dateJournal);
    	String[] partsNow = strNow.split("-");
    	String[] partsJournal = strNow.split("-");
    	
    	
    	int nowYear = Integer.parseInt(partsNow[0]);
    	int nowMonth = Integer.parseInt(partsNow[1]);
    	 
    	int journalYear = Integer.parseInt(partsJournal[0]);
    	int journalMonth = Integer.parseInt(partsJournal[1]);
    	
    	boolean createNewVersion = false;
    	if(nowYear>journalYear)
    	{
    		createNewVersion = true;
    	}
    	else
    	{
    		if(nowMonth-journalMonth>=3)
    			createNewVersion = true;
    	}
    	
    	if(createNewVersion)
    	{
    		Journal newJournal = new Journal();
    		newJournal.setEdition(nowYear);
    		newJournal.setVolume((int)Math.ceil((double) nowMonth/3));
    		newJournal.setWhenCreated(new Date());
    		 
    		journalDAO.addJournal(newJournal);
    		String body="New Volume is coming, going to website and checking.\n"
        		 	 + "Journal"+newJournal.toString()+"\n"+"Regards,\n"+"teamo company";
    		Set<SubscribeMailingList> subscribeCollection = subscribeDAO.getNextEditonList();
    		Iterator it = subscribeCollection.iterator();
    		while(it.hasNext())
    		{
    			SubscribeMailingList m = (SubscribeMailingList) it.next();
    			emailUtils.sendEmail(m.getEmail(), "new edition", body);
    		}
        	return newJournal;
    	}
    	else
    	{
    		return journalDAO.getCurrentJournal();
    	}
    }
    
    public JournalSetting getCurrentJournalSetting()
    {
    	return journalDAO.getCurrentJournalSetting();
    }
}
