package com.thales.formation.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.thales.formation.config.jms.JmsProperties;
import com.thales.formation.message.EmailMessage;
import com.thales.formation.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SendEmailListener {
	
	@Autowired
	private EmailService emailService;
	
	@JmsListener(destination = JmsProperties.SEND_EMAIL)
    public void receiveMessage(EmailMessage email) {
		log.info("Sending email to <" + email.getTo() + ">");
		emailService.processEmailMessage(email);
    }

}
