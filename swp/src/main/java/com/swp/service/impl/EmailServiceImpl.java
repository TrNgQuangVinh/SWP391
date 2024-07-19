package com.swp.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.swp.service.EmailService;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
@Component
public class EmailServiceImpl implements EmailService {
	
	@Value("${spring.mail.sender.name}")
    private String sender;
	
    @Autowired
    private JavaMailSender emailSender;
    
    @Autowired
    private SimpleMailMessage template;
    
    @Async
    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
    	try {
			SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom(sender + "<" + "no-reply@andiamond.com" + ">");
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
    }
    
    @Async
    @Override
    public void sendSimpleMessageUsingTemplate(String to, String subject,String ...templateModel) {
        String text = String.format(template.getText(), templateModel);  
        sendSimpleMessage(to, subject, text);
    }

    @Async
	@Override
	public void sendMimeMessageWithAttachments(String to, String subject, String text) {
		try {
			MimeMessage message = emailSender.createMimeMessage(); 
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setPriority(2);
	        helper.setFrom(new InternetAddress(sender + "<" + "no-reply@andiamond.com" + ">"));
	        helper.setTo(to); 
	        helper.setSubject(subject); 
	        helper.setText(text);
	        //Add attachment
	        FileSystemResource image = new FileSystemResource(new File(System.getProperty("user.home") + "/Pictures/image name here"));
	        helper.addAttachment(image.getFilename(), image);
	        //Send
	        emailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
}
