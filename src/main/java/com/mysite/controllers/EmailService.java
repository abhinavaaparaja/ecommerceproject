package com.mysite.controllers;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

	public static final String REPLAY_TO_ADDRESS="abhinavajustclick@gmail.com";

	public static final String FROM_ADDRESS="abhinavajustclick@gmail.com";
	
	@Autowired
	public   JavaMailSender javaMailSender;
	
	public  void send(String custemailid,String subject,String body) throws MessagingException{

		MimeMessage mail=javaMailSender.createMimeMessage();
		MimeMessageHelper helper= new MimeMessageHelper(mail,true);
		helper.setTo(custemailid);
		helper.setReplyTo(REPLAY_TO_ADDRESS);
		helper.setFrom(FROM_ADDRESS);
		helper.setSubject(subject);
		helper.setText(body);
		javaMailSender.send(mail);
	}
}

