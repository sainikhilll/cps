package com.revature.cpsrest.controller;

import java.util.List;

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
	
	@Autowired
	private TripService tripService;
	
	@PostMapping
	public List<Trip> searchTrip(@RequestBody Trip trip) {
		return tripService.passTrip(trip);
	
		
	}
	
	

}
