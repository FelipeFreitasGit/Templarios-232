package com.loja.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);
	
	public void enviar(String toUser, String assunto, String mensagem) {
		
		SimpleMailMessage emailMessage = new SimpleMailMessage();
		
		emailMessage.setTo(toUser);
		emailMessage.setSubject(assunto);
		emailMessage.setText(mensagem);
		
		try {
			
			LOG.info("Enviando email...");
			mailSender.send(emailMessage);
			LOG.info("Email enviado!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
