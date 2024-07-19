package com.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp.dto.DiamondDTO;
import com.swp.dto.MailDTO;
import com.swp.service.EmailService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private EmailService emailServ;
	
	@PostMapping("/test-request")
	 public ResponseEntity<String> testPostRequest() {
	    return ResponseEntity.ok("POST request successful");
	}
	@PostMapping("/test-email-simple")
	public ResponseEntity<String> testPostEmailSimple(@RequestBody MailDTO mail) {
		String to = mail.getTo();
		String subject = mail.getSubject();
		String content = mail.getContent();
		emailServ.sendSimpleMessage(to, subject, content);
		//emailServ.sendMimeMessageWithAttachments(to, subject, content);
	    return ResponseEntity.ok("POST Mail successful");
	}
	
	@PostMapping("/test-email-attachment")
	public ResponseEntity<String> testPostEmailAttachment(@RequestBody MailDTO mail) {
		String to = mail.getTo();
		String subject = mail.getSubject();
		String content = mail.getContent();
		//emailServ.sendSimpleMessage(to, subject, content);
		emailServ.sendMimeMessageWithAttachments(to, subject, content);
	    return ResponseEntity.ok("POST Mail successful");
	}
	
}
