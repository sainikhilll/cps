package com.revature.cpsrest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Owner;
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

	@PostMapping("/search")
	public List<Trip> searchTrip(@RequestBody Trip trip) {
		LOGGER.debug("{}",trip);
		return tripService.passTrip(trip);		
	}
		
	@PostMapping
	public void create(@RequestBody Trip trip){
		LOGGER.info("Trip Controller Starts");
		LOGGER.debug("Trip: {}", trip);
		tripService.save(trip);
	}
	
	@GetMapping("/user/{id}")
	public Owner getOwner(@PathVariable int id) {
		return tripService.getOwnerByUserId(id);
	}
	
	@PutMapping("/update")
	public void updateTrip(@RequestBody Trip trip) {
		tripService.updateTrip(trip);
	}
}
