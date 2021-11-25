package com.revature.cpsrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.OwnerRating;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.repository.OwnerRepository;
import com.revature.cpsrest.repository.TripBookingRepository;
import com.revature.cpsrest.service.OwnerRatingService;
import com.revature.cpsrest.service.OwnerService;

@RestController
@RequestMapping("/ownerRatings")
public class OwnerRatingController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);	
//	@GetMapping("/{ownerId}")
//	public List<OwnerRating> getOwnerRatingsByOwnerId(@PathVariable int ownerId){
//		//Owner o = ownerService.getOwnerByUserId(userId);
//		return ownerRatingService.getOwnerRatingsByOwnerID(ownerId);

	@Autowired
	private OwnerRatingService ownerRatingService;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private TripBookingRepository tripBookingRepository;
	
	
	@GetMapping("/{ownerId}")
	public List<TripBooking> getOwnerRatingsByOwnerId(@PathVariable int ownerId){
		//Owner o = ownerService.getOwnerByUserId(userId);
		return tripBookingRepository.getOwnerRatingsByOwnerId(ownerId);
	}

	@GetMapping()
	public List<OwnerRating> getRatings(@PathVariable int ownerId) {
		Owner owner = ownerRepository.getOwnerByUserId(ownerId);
		return ownerRatingService.getRatings(owner.getId());

	}
}
