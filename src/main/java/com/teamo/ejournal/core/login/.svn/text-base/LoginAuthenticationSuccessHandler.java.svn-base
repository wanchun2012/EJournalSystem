package com.teamo.ejournal.core.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.teamo.ejournal.core.util.AjaxUtils;

@Component("loginAuthenticationSuccessHandler")
public class LoginAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	public LoginAuthenticationSuccessHandler() {    
    }
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {  
             	
    	logger.info("login success");
    	
    	//check if login is originated from ajax call
        if (AjaxUtils.isAjaxRequest(request)) {
            try {
            	response.setContentType("application/json");
            	ObjectMapper mapper = new ObjectMapper();
            	PrintWriter out = response.getWriter();
            	out.println(mapper.writeValueAsString(authentication));
            	out.flush();
	        } catch (IOException e) {               
	           //handle exception...
	        }
        } else {            
            setAlwaysUseDefaultTargetUrl(false);
            //...
        }
    }
	
}
