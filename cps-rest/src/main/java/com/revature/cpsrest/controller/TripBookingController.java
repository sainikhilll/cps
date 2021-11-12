package com.revature.cpsrest.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.service.PassengerService;
import com.revature.cpsrest.service.TripBookingService;
import com.revature.cpsrest.service.TripService;

@RestController
@RequestMapping("/trip-bookings")
public class TripBookingController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TripBookingService tripBookingService;
	@Autowired
	private TripService tripService;
	@Autowired
	private PassengerService passengerService;

	@PostMapping
	public void create(@RequestBody TripBooking booking) {
		Passenger p = passengerService.getPassengerById(booking.getPassenger().getUser().getId());
		LOGGER.debug("passenger Id: {}", p);
		booking.getPassenger().setId(p.getId());
		;
		tripBookingService.save(booking);
		Optional<Trip> tripUpdated = tripService.getById(booking.getTrip().getId());
//	Trip t=null;
		tripUpdated.ifPresent(t -> {
			t.setNumberOfSeatsAvailable(t.getNumberOfSeatsAvailable() - booking.getSeatsBooked());
		});
		tripUpdated.ifPresent(l -> {
			tripService.save(l);
		});
//	
	}

}
