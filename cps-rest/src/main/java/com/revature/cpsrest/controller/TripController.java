package com.revature.cpsrest.controller;


import java.util.Optional;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
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

import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.service.TripService;


@RestController
@RequestMapping("/trips")
public class TripController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TripService tripService;
	
	@GetMapping("/{id}")
    public Optional<Trip> getTrip(@PathVariable int id) {
    	LOGGER.debug("Trip Id: {}",id);
    	return tripService.getById(id);
    }

	
	@PostMapping
	public List<Trip> searchTrip(@RequestBody Trip trip) {
		LOGGER.debug("{}",trip);

		return tripService.passTrip(trip);
		
	   
		
	}
	

}

