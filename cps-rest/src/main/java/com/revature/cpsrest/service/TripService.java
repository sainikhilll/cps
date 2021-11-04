package com.revature.cpsrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.repository.TripRepository;

@Service
public class TripService {
	
	@Autowired
	private TripRepository tripRepo;
	
	public List<Trip> passTrip(Trip trip){
		return  tripRepo.getTrips(trip.getOrigin(),trip.getDestination(),trip.getPrice());
		
	}

}
