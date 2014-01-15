package com.teamo.ejournal.core.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.teamo.ejournal.core.util.AjaxUtils;

@Component("loginAuthenticationFailureHandler")
public class LoginAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	public LoginAuthenticationFailureHandler(){
	}
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		super.onAuthenticationFailure(request, response, exception);
		
		logger.info("login fail, exception: "+exception);
		
		if(exception.getClass().isAssignableFrom(UsernameNotFoundException.class)) {
		  logger.info("BAD_CREDENTIAL");
		} else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
		  logger.info("USER_DISABLED");
		}
		
    	//check if login is originated from ajax call
        if (AjaxUtils.isAjaxRequest(request)) {
            try {
            	response.getWriter().print("fail");
                response.getWriter().flush();
	        } catch (IOException e) {               
	           //handle exception...
	        }
        } else {            
        	setDefaultFailureUrl("/");
            //...
        }
	}	
}
