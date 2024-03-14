package com.app.service;

import com.app.pojos.Contact;
import com.app.pojos.User;


public interface IUserService {
	User addOrUpdateUserDetails(User user);
	User authenticateUser(String email, String pass);
	//User getByEmail(String email);
	//Contact addMessage(Contact c, User u);
	Contact addMessage(Contact c);
	String getByEmail(String email, Contact c);
}
