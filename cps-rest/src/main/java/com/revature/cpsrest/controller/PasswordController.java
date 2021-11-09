package com.revature.cpsrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.exception.InvalidCredentialsException;
import com.revature.cpsrest.model.User;
import com.revature.cpsrest.service.PasswordService;


@RestController
@RequestMapping("/authenticate")


public class PasswordController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordController.class);

	@Autowired
	private PasswordService passwordService;

	@PutMapping("/{np}")
	public User getEmail(@RequestBody User user,@PathVariable String np) {
		
		LOGGER.debug("User {}", user);
		User returnedField = passwordService.getByEmailAndPassword(user.getEmail(),user.getPassword());
		LOGGER.debug("passwordReturned:", returnedField);
		if (returnedField == null) {
			throw new InvalidCredentialsException(" Enter Valid Credntials");
		} else  {
			returnedField.setPassword(np);
			returnedField.setId(returnedField.getId());
			passwordService.save(returnedField);
			
			return returnedField;
		}
			
		
	}
	
}


