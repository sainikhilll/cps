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

import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.service.OwnerNotificationsService;

@RestController
@RequestMapping("/notifications")
public class OwnerNotificationsController {
	private final Logger LOGGER = LoggerFactory.getLogger(OwnerNotificationsController.class);

	@Autowired 
	private OwnerNotificationsService ownerNotificationsService;
	
	@GetMapping("/{ownerId}")
	public List<TripBooking> getTripBookings(@PathVariable int ownerId){
		LOGGER.info("Owner Notifications Controller Starts");
		LOGGER.debug("owner id: {}", ownerId);
		return ownerNotificationsService.getTripBookings(ownerId);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TripBooking tripBooking) {
		LOGGER.debug("TripBooking:{}",tripBooking);
		ownerNotificationsService.save(tripBooking);
	}
}
