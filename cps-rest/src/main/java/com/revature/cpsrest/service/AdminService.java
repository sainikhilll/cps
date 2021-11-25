package com.revature.cpsrest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.repository.AdminRepository;
import com.revature.cpsrest.repository.OwnerRepository;
import com.revature.cpsrest.repository.TripBookingRepository;
import com.revature.cpsrest.repository.TripRepository;

@Service
public class AdminService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private AdminRepository adminrepository;

	@Autowired
	private OwnerRepository ownerrepository;

	
	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private TripBookingRepository tripBookingRepository;
	
	



	public List<Owner> list() {
		LOGGER.info("Start");
		return adminrepository.getPendingOwner();
	}

	
	public void update(Owner owner)
	{
		adminrepository.save(owner);
	}
	
	public Owner  getOwner(int id) {
		return ownerrepository.getById(id);
	}
	
	public Trip getTripId(int id) {
		return tripRepository.getById(id);
	}
	
	public List<TripBooking> getTripBooking(int id) {
		return tripBookingRepository.getByTripId(id);
	}
	
	
	public List<Trip> trips(){
		LOGGER.info("Start");
		return adminrepository.getTrip();
	}
	public List<Trip> completedTrips(){
		LOGGER.info("Start");
		return adminrepository.getCompletedTrip();
	}
	
	 public void tripStatus(Trip trip) {
		 LOGGER.info("Start");
		 tripRepository.save(trip);
		 
	 }
	 public void tripBookingStatus(TripBooking tripBook) {
		 LOGGER.info("Start");
		 tripBookingRepository.save(tripBook);
		 
	 }
	
}

