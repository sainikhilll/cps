package com.revature.cpsrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.User;
import com.revature.cpsrest.service.OwnerService;
import com.revature.cpsrest.service.UserService;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);

	@Autowired
	private OwnerService service;
	
	 @PostMapping
		public void create(@RequestBody Owner owner) {
	
		 LOGGER.debug("{}",owner);
//		 User user1 = new User();
//		 user1.setEmail(owner.getUser().getEmail());
//		 user1.setPassword(owner.getUser().getPassword());
//		 user1.setRole("owner");
//		 LOGGER.debug("{}",user1);
//		 User user2 = userService.save(user1);
//		 LOGGER.debug("id:{}",user2.getId());
//		 owner.setUser(user2);
		 service.save(owner);
		 
		 
		}
	 
	 
//	    @PutMapping
//	  	public void update(@RequestBody Owner owner) {
//	  		
//	  		service.save(owner);
//	  	}

	}

