package by.itransition.fanfic.service.impl;

import java.util.ResourceBundle;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import by.itransition.fanfic.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	private JavaMailSenderImpl mailSender;
	
	public EmailServiceImpl() {
		ResourceBundle emailResourceBundle = ResourceBundle.getBundle("email");
		mailSender = new JavaMailSenderImpl();
		mailSender.setHost(emailResourceBundle.getString("host"));
		mailSender.setPort(Integer.valueOf(emailResourceBundle.getString("port")));
		mailSender.setUsername(emailResourceBundle.getString("username"));
		mailSender.setPassword(emailResourceBundle.getString("password"));
		mailSender.getJavaMailProperties().setProperty("mail.transport.protocol", "smtp");
		mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
		mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");
	}
	
	public void sendMessage(String email, String message) {
		SimpleMailMessage passwordMessage = new SimpleMailMessage();
		passwordMessage.setTo(email);
		passwordMessage.setFrom(mailSender.getUsername());
		passwordMessage.setText(message);
		mailSender.send(passwordMessage);	
	}

}
