package com.teamo.ejournal.core;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //available since spring 3.2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler({FileNotFoundException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict1(Exception ex, WebRequest request) {
		ex.printStackTrace();
		logger.info("exception: "+ex);
		
		String bodyOfResponse = "File creation problem.";
		
		return handleExceptionInternal(ex, 
					bodyOfResponse,
					new HttpHeaders(),
					HttpStatus.CONFLICT,
					request);
	}
	
	@ExceptionHandler(NullPointerException.class)
	protected ResponseEntity<Object> handleConflict2(Exception ex, WebRequest request) {
		ex.printStackTrace();
		logger.info("exception: "+ex);
		
		String bodyOfResponse = "Null pointer problem.";
		
		return handleExceptionInternal(ex, 
					bodyOfResponse,
					new HttpHeaders(),
					HttpStatus.CONFLICT,
					request);
	}
	
}
