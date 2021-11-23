package com.revature.cpsrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.OwnerRating;
import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.service.OwnerRatingService;
import com.revature.cpsrest.service.PassengerService;

@RestController
@RequestMapping("/ownerratings")
public class OwnerRatingController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PassengerController.class);
	
	@Autowired
	private OwnerRatingService ownerRatingService;
	@Autowired
	private PassengerService passengerService;
	
	@PostMapping
	public void create(@RequestBody OwnerRating ownerRating)
	{
		LOGGER.debug("{}",ownerRating);
		Passenger p = passengerService.getPassengerById(ownerRating.getPassenger().getUser().getId());
		ownerRating.getPassenger().setId(p.getId());
		ownerRatingService.save(ownerRating);
	}
	@GetMapping("{status}")
	public List<Trip> getTripByStatus(@PathVariable String status)
	{
		return ownerRatingService.userGetServiceByStatus(status);
	}
	

}
