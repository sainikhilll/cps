package com.revature.cpsrest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.repository.TripRepository;

@Service
public class TripService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TripService.class);
	
	@Autowired
	private TripRepository tripRepository;
	
	public void save(Trip trip) {
		LOGGER.info("Trip Service Starts");
		tripRepository.save(trip);
	}
	
	public Owner getOwnerByUserId (int userId) {
		return tripRepository.getOwnerByUserId(userId);
	}
}
