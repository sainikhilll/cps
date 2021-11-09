package com.revature.cpsrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.exception.InvalidCredentialsException;
import com.revature.cpsrest.model.User;
import com.revature.cpsrest.service.UserService;

@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@PostMapping("/authenticate")
	public User login(@RequestBody User user)throws Exception {
		
		User foundUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		//LOGGER.debug(foundUser.getRole());
		
		if(foundUser == null) {
			
			throw new InvalidCredentialsException("Enter valid credentials");
		}
		else {
			return foundUser;
		}
	}

}
