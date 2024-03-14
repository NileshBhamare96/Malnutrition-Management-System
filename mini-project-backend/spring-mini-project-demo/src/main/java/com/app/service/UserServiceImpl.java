package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ContactRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Contact;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public User addOrUpdateUserDetails(User user) {
		return userRepo.save(user);
	}
	@Override
	public User authenticateUser(String email, String pass) {
		return userRepo.findByEmailAndPassword(email, pass).orElseThrow(() -> new RuntimeException("User login failed : Invalid credentials"));
	}
//	@Override
//	public User getByEmail(String email) {
//		return userRepo.findByEmail(email);
//	}
	@Override
	public String getByEmail(String email, Contact c) {
		User u = userRepo.findByEmail(email);
		c.setUser(u);
		addMessage(c);
		return "Message successfully added";
	}
//	@Override
//	public Contact addMessage(Contact c, User u) {
//		return contactRepo.save(c);
//	}
	@Override
	public Contact addMessage(Contact c) {
		return contactRepo.save(c);
	}
}
