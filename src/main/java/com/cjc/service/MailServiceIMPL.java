package com.cjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cjc.model.User;
import com.cjc.repository.UserRepository;

@Service
public class MailServiceIMPL implements MailService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private JavaMailSender sender;

	@Override
	public void saveUser(User user) {
		repo.save(user);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmail());

		message.setSubject("Welcome to CJC Task");

		message.setText("Dear CJC user " + user.getUsername() + ",\n\n" + "Thank you for registering on CJC App !\n"
				+ "Your username: " + user.getUsername() + "\n" + "Your password: " + user.getPassword() + "\n\n"
				+ "Best regards,\n" + "CJC Admin");

		sender.send(message);

	}

	@Override
	public User loginUser(String username, String password) {

		return repo.findByUsernameAndPassword(username, password);

	}

	
	
}
