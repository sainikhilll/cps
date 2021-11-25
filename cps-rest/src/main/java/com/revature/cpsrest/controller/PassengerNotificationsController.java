package com.revature.cpsrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.service.PassengerNotificationsService;

@RestController
@RequestMapping("/notifications")
public class PassengerNotificationsController {
	private final Logger LOGGER = LoggerFactory.getLogger(PassengerNotificationsController.class);

	@Autowired
	private PassengerNotificationsService passengerNotificationsService;

	@GetMapping("/{passengerId}")
	public List<TripBooking> getTripBookings(@PathVariable int passengerId) {
		LOGGER.info("Passenger Notifications Controller Starts");
		LOGGER.debug("passenger id: {}", passengerId);

		return passengerNotificationsService.getTripBookings(passengerId);
	}

	@PutMapping
	public void update(@RequestBody TripBooking tripBooking) {
		passengerNotificationsService.save(tripBooking);
	}
}
