package com.revature.cpsrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.repository.TripBookingRepository;
import com.revature.cpsrest.service.OwnerRatingService;
import com.revature.cpsrest.service.OwnerService;

@RestController
@RequestMapping("/ownerRatings")
public class OwnerRatingController {
	@Autowired
	private OwnerRatingService ownerRatingService;
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private TripBookingRepository tripBookingRepository;
	
	@GetMapping("/{ownerId}")
	public List<TripBooking> getOwnerRatingsByOwnerId(@PathVariable int ownerId){
		//Owner o = ownerService.getOwnerByUserId(userId);
		return tripBookingRepository.getOwnerRatingsByOwnerId(ownerId);
	}
}