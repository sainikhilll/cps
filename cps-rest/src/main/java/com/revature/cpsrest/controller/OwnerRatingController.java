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
import com.revature.cpsrest.service.PassengerService;

@RestController
@RequestMapping("/ownerratings")
public class OwnerRatingController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PassengerController.class);
	
	@Autowired
	private OwnerRatingService ownerRatingService;
	@Autowired
	private PassengerService passengerService;
	

}
