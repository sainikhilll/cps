package com.revature.cpsrest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.User;
import com.revature.cpsrest.repository.PasswordRepository;

@Service

public class PasswordService {
private static final Logger LOGGER = LoggerFactory.getLogger(PasswordService.class);

	
	@Autowired
	private PasswordRepository passwordRepository;
	
	public User getByEmailAndPassword(String email,String password){
		return passwordRepository.findByEmailAndPassword(email,password);
	}
	public void save(User user)
	{
		LOGGER.debug("{}",user);
		passwordRepository.save(user);
	}

}
