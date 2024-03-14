package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Contact;
import com.app.pojos.User;
import com.app.service.IUserService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private IUserService userService;
	public UserController() {
		System.out.println("in ctor of " + getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addUserDetails(@RequestBody User u) {
		System.out.println("in add emp");
		double heightInMeters  = u.getHeight() / 100;
		u.setBMI(u.getWeight()/(heightInMeters * heightInMeters));
		System.out.println(u.getBMI());
		//if(u.getEmail() != null)
			//return "User already exists";
		return new ResponseEntity<>(userService.addOrUpdateUserDetails(u), HttpStatus.OK);
	}
	
//	@PostMapping("/login")
//	public User validateUser(@RequestBody User u) {
//		String email = u.getEmail();
//		String password = u.getPassword();
//		System.out.println("in validate user " + getClass());
//		try {
//			return userService.authenticateUser(email, password);
//		} catch (RuntimeException e) {
//			System.out.println("err in validateUser " + getClass() + " " + e);
//			return null;
//		}
//	}
	@PostMapping("/login")
	public ResponseEntity<?> validateUser(@RequestBody User u) {
		String email = u.getEmail();
		String password = u.getPassword();
		System.out.println("in validate user " + getClass());
		try {
			User user = userService.authenticateUser(email, password);
			System.out.println(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println("err in validateUser " + getClass() + " " + e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
//	@PostMapping("/contact")
//	public ResponseEntity<?> getMessage(@RequestBody Contact c) {
//		Contact contact = new Contact(c.getName(), c.getAddress(), c.getMessage());
//		String email = c.getUser().getEmail();
//		User u = userService.getByEmail(email);
//		contact.setUser(u);
//		System.out.println("in contact us " + getClass());
//		System.out.println(contact);
//		Contact con = userService.addMessage(contact);
//		return new ResponseEntity<>(con, HttpStatus.OK);
//		
//	}
	
	@GetMapping("/contact")
	public ResponseEntity<?> getMessage(@RequestParam String name, @RequestParam String address, @RequestParam String message, @RequestParam String storedEmail) {
		Contact contact = new Contact(name, address, message);
		String msg = userService.getByEmail(storedEmail, contact);
		System.out.println("in contact us " + getClass());
		System.out.println(contact);
		//Contact con = userService.addMessage(contact, u);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
