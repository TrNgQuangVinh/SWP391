package com.swp.service;

public interface EmailService {
	void sendSimpleMessage(String to, String subject, String text);

	void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel);
	
	void sendMimeMessageWithAttachments(String to, String subject, String text);
}
