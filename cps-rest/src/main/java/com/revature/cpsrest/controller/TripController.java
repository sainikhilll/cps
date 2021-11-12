package com.revature.cpsrest.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

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
	static final Logger LOGGER = LoggerFactory.getLogger(TripController.class);
	
	@Autowired
	private TripService tripService;
	
	
	@PostMapping
	public List<Trip> searchTrip(@RequestBody Trip trip) {
		LOGGER.debug("{}",trip);
		return tripService.passTrip(trip);
	}
	
	

}
