package com.revature.cpsrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.service.TripService;

@RestController
@RequestMapping("/trips")
public class TripController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TripController.class);
	
	@Autowired
	private TripService tripService;
	
	@PostMapping
	public void create(@RequestBody Trip trip){
		LOGGER.info("Trip Controller Starts");
		LOGGER.debug("Trip: {}", trip);
		tripService.save(trip);
	}
}
