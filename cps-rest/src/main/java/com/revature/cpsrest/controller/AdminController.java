package com.revature.cpsrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.service.AdminService;



@RestController
//@RequestMapping
public class AdminController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
@Autowired
private AdminService adminservice;
@GetMapping("/approvals")

public List<Owner> ownerdetails(){

	return adminservice.list();

	}

@GetMapping("/updates/{id}")
public void update(@PathVariable int id) {

	Owner owner=adminservice.getOwner(id);
	
	owner.setStatus("Approved");
	adminservice.update(owner);
}

@GetMapping("/rejects/{id}")
public void reject(@PathVariable int id) {

	Owner owner=adminservice.getOwner(id);
	
	owner.setStatus("Rejected");
	adminservice.update(owner);
}

@GetMapping("/trips")
public List<Trip> allTrips() {
	LOGGER.info("View Trip Started");	
	return adminservice.trips();
}
@GetMapping("/completedTrips")
public List<Trip> allCompletedTrips() {
	LOGGER.info("View Trip Started");	
	return adminservice.completedTrips();
}

@GetMapping("/canceltrips/{id}")
public void canceltrips(@PathVariable int id) {
	LOGGER.info("CancelTrip Started");
	Trip trip = adminservice.getTripId(id);
	trip.setStatus("Called Off");
	adminservice.tripStatus(trip);
	
	List<TripBooking> tripBooking = adminservice.getTripBooking(id);
	for(TripBooking tripBook : tripBooking) {
		tripBook.setStatus("Called Off");
		adminservice.tripBookingStatus(tripBook);
	}
	
	
}




}
