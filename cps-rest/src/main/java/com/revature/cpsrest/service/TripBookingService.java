package com.revature.cpsrest.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.repository.OwnerRepository;
import com.revature.cpsrest.repository.TripBookingRepository;

@Service
@Transactional
public class TripBookingService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TripBookingRepository tripBookingRepository;

	@Autowired
	private OwnerRepository ownerRepository;


	public void save(TripBooking booking) {
		tripBookingRepository.save(booking);
	}


	public List<TripBooking> getOwnerRatingsByOwnerID(int ownerId) {
		return tripBookingRepository.getOwnerRatingsByOwnerId(ownerId);
	}

	public Set<Trip> getTripBookings(int userId) {
		LOGGER.debug("Service start");
		Owner owner = ownerRepository.getOwnerByUserId(userId);
		LOGGER.debug("{}", owner);
		Set<Trip> trips = tripBookingRepository.getTripsbyOwnerId(owner.getId());
		LOGGER.debug("{}", trips.size());
		return trips;
	}

	public TripBooking getTripBooking(int id) {
		return tripBookingRepository.getById(id);
	}

	public TripBooking update(TripBooking tripBooking) {
	    
		return tripBookingRepository.save(tripBooking);

	}
	
	public TripBooking getTripBookingById(int id)
	{
		return tripBookingRepository.getById(id);
	}

}
