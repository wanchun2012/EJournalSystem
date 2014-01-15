package com.teamo.ejournal.core.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component("emailUtils")
public class EmailUtils {

	private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);
	
	@Autowired
    private JavaMailSender mailSender;
	
	public boolean sendEmail(String recipientAddress, String subject, String message) throws MailException{
         
        // prints debug info
        logger.debug("To: " + recipientAddress);
        logger.debug("Subject: " + subject);
        logger.debug("Message: " + message);
         
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
         
        // sends the e-mail
        try{
        	logger.info("mailsender: "+mailSender);
        	mailSender.send(email);
        	logger.info("sent mail!");
        } catch (MailException mex){
        	logger.error("Error trying to send email: "+mex.getMessage());
        	throw mex;
        }
		
        logger.info("Mail sent to: "+recipientAddress);
		return true;
	}
	
	public boolean sendMIMEEmail(final String from,final String to,final String subject, final String message) throws MailException{
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws MessagingException {
            	if (!from.isEmpty()) mimeMessage.setFrom(new InternetAddress(from));
                mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
                mimeMessage.setSubject(subject);
                //html content
                mimeMessage.setContent(message, "text/html; charset=utf-8");
                //mimeMessage.setText("");
                
                /*
                //multipart example
                Multipart multiPart = new MimeMultipart("alternative");
                MimeBodyPart htmlPart = new MimeBodyPart();
    			htmlPart.setContent(message, "text/html; charset=utf-8");
                mimeMessage.setContent(multiPart);
                */
            }
        };
        mailSender.send(preparator);
        return true;
	}
}
