package com.teamo.ejournal.core.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.teamo.ejournal.core.model.ArticleUpload;

public class JacksonJSONUtils {

	private static final Logger logger = LoggerFactory.getLogger(JacksonJSONUtils.class);
	
	public static ArticleUpload retrieveArticleModel(String json){
		
		ArticleUpload au = new ArticleUpload();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			// read from file, convert it to user class
			au = mapper.readValue(json, ArticleUpload.class);
			logger.info("mapper: "+au);
	 
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		
		logger.info("Starting to parse...");
		
	    try {
	    	 
	    	JsonFactory jfactory = new JsonFactory();
	     
	    	
	    	JsonParser jParser = jfactory.createJsonParser(json);
	     
	    	// loop until token equal to "}"
	    	while (jParser.nextToken() != JsonToken.END_OBJECT) {
	     
	    		jParser.nextToken(); // current token is "{", move next
	    		
	    		logger.info("jParser loop 1: "+jParser.getCurrentName());
	    		
	    		String fieldname = jParser.getCurrentName();
	    		
	    		if ("title".equals(fieldname)) {
	    			jParser.nextToken();
	    			au.setTitle(jParser.getText());
	    		}
	    		
	    		if ("keywords".equals(fieldname)) {
		    		  // messages is array, loop until token equal to "]"
		    		  while (jParser.nextToken() != JsonToken.END_ARRAY) {
		    			  au.getKeywords().add(jParser.getText());
		    		  }
		    		  jParser.nextToken(); //last token need to skip
		    	}
	    		
	    		if ("paperAbstract".equals(fieldname)) {
	    			jParser.nextToken();
	    			au.setPaperAbstract(jParser.getText());
	    		}
	    		
	    		if ("authors".equals(fieldname)) {
		    		  // messages is array, loop until token equal to "]"
		    		  while (jParser.nextToken() != JsonToken.END_ARRAY) {
		    			  jParser.nextToken(); // current token is "{", move next
		    			  
		    			  logger.info("jParser loop 2: "+jParser.getCurrentName());
		    			  
		    			  Author author = new Author();
		    			  
		    			  while (jParser.nextToken() != JsonToken.END_OBJECT) {
		    				  
		    				  logger.info("jParser loop 3: "+jParser.getCurrentName());
		    				  
		    				  	String fieldname2 = jParser.getCurrentName();
		    		    		
		    		    		if ("firstname".equals(fieldname2)) {
		    		    			jParser.nextToken();
		    		    			author.setFirstname(jParser.getText());
		    		    		}
		    		    		
		    		    		if ("secondname".equals(fieldname2)) {
		    		    			jParser.nextToken();
		    		    			author.setSecondname(jParser.getText());
		    		    		}
		    		    		
		    		    		if ("email".equals(fieldname2)) {
		    		    			jParser.nextToken();
		    		    			author.setEmail(jParser.getText());
		    		    		}
		    		    		
		    		    		if ("affiliation".equals(fieldname2)) {
		    		    			jParser.nextToken();
		    		    			author.setAffiliation(jParser.getText());
		    		    		}
		    			  }
		    			  
		    			  au.getAuthors().add(author);
		    		  }
		    	}
	    	 }
	    	  	jParser.close();
	         } catch (JsonGenerationException e) {
	        	 e.printStackTrace();
	        	 logger.info("JsonGenerationException");
	         } catch (JsonMappingException e) {
	        	 e.printStackTrace();
	        	 logger.info("JsonMappingException");
	         } catch (IOException e) {	     
	        	 e.printStackTrace();
	        	 logger.info("IOException");
	         }
	    
	    logger.info("au object: "+au.toString());
	    */
	    
	    return au;
	}
	
}
