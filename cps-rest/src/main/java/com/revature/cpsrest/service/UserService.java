package com.revature.cpsrest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.User;
import com.revature.cpsrest.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		 return userRepository.save(user);

	}
}