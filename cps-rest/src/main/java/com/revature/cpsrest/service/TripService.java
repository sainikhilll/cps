package com.revature.cpsrest.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.repository.TripRepository;

@Service
@Transactional
public class TripService {
	@Autowired
	private TripRepository tripRepository;
	
	public Optional<Trip> getById(int id ) {
	return tripRepository.findById(id);
	}
		
	public void save(Trip trip) {
		 tripRepository.save(trip);
		
	}

}
