package com.teamo.ejournal.core.login;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class SystemPermissionEvaluator implements PermissionEvaluator {

	private static final Logger logger = LoggerFactory.getLogger(SystemPermissionEvaluator.class);
	
	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		logger.info("Evaluating permission for: "+auth+ " ;param1: "+targetDomainObject+" ;param2: "+permission);
		
		boolean hasPermission = false;
		if ( auth != null && permission instanceof String){
			logger.debug("Casting user...");
			AuthenticatedUser user = (AuthenticatedUser)auth.getPrincipal();
			String strPermission = (String)permission;
			if (strPermission.equals("sameID")){
				logger.debug("Casting object to integer...");
				Integer idTest;
				try{
					idTest = Integer.parseInt((String)targetDomainObject);
				} catch (Exception e){
					e.printStackTrace();
					return false;
				}
				hasPermission = user.getUserId() == idTest;
				logger.debug("Comparing IDs = "+hasPermission);					
			}
		} else {
			hasPermission = false; 
		}
		return hasPermission;
		
	}

	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId,
			String targetType, Object permission) {
		//call example: hasPermission(#authorName,'test22','test23')
		logger.info("Not supported. "+auth+ " ;;; "+targetId+" ;;; "+targetType+" ;;; "+permission);
		throw new RuntimeException("Id and Class permissions are not supperted by this application");
	}

}
