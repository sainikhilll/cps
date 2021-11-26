package com.revature.cpsrest.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.repository.TripRepository;

@Service
@Transactional
public class TripService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TripService.class);

	@Autowired
	private TripRepository tripRepository;

	public Optional<Trip> getById(int id) {
		return tripRepository.findById(id);
	}

	public List<Trip> passTrip(Trip trip) {
		return tripRepository.getTrips(trip.getOrigin(), trip.getDestination(), trip.getDate());
	}

	public void save(Trip trip) {
		LOGGER.info("Trip Service Starts");
		tripRepository.save(trip);
	}

	public Owner getOwnerByUserId(int userId) {
		return tripRepository.getOwnerByUserId(userId);
	}

	public Trip updateTrip(Trip trip) {
		return tripRepository.save(trip);
	}

	public void tripStatus(Trip trip) {
		LOGGER.info("Start");
		tripRepository.save(trip);
	}

	public Trip getTripId(int id) {
		return tripRepository.getById(id);
	}

	public Set<Trip> getCompletedTripsOfPassenger(int passengerId) {
		return tripRepository.getCompletedTrips(passengerId);

	}
}
