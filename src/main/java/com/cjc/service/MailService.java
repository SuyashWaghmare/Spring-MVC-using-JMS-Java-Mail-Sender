package com.cjc.service;

import java.util.List;

import com.cjc.model.User;

public interface MailService {

	void saveUser(User user);
	
	User loginUser(String username, String password);

	

	

}
