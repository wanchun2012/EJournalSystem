package com.teamo.ejournal.core.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamo.ejournal.dao.LoginDAOImpl;
import com.teamo.ejournal.orm.UserEntity;

@Transactional
@Service("userDetailsService")
public class LoginServiceImpl implements UserDetailsService{

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginDAOImpl userDao;
	
	@Autowired
	private Assembler assembler;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//logger.info("trying to load by username...");
		UserEntity userEntity = null;
		try{
			userEntity = userDao.findByName(username);			
		}catch(Exception e){
			logger.info("exception::: "+e);
		}
		//logger.info("username: "+username+" ;;; object: "+userEntity);
		if (userEntity == null){
			logger.info("failed...");
			throw new UsernameNotFoundException("Error: user not found");
		}
		return assembler.buildSpecialUserFromUserEntity(userEntity);
	}

}
