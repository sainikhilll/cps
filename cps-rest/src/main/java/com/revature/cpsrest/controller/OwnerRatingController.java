package com.revature.cpsrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.OwnerRating;
import com.revature.cpsrest.service.OwnerRatingService;

@RestController
@RequestMapping("/viewratings")
public class OwnerRatingController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private OwnerRatingService ownerRatingService;
	
	@GetMapping("/{ownerId}")
	public List<OwnerRating> getRatings(@PathVariable int ownerId) {
		return ownerRatingService.getRatings(ownerId);
	}
}
