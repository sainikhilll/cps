package com.revature.cpsrest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.repository.TripBookingRepository;

@Service
@Transactional
public class TripBookingService {

	@Autowired
	private TripBookingRepository tripBookingRepository;
	

	public void save(TripBooking booking) {
		tripBookingRepository.save(booking);
	}
	public TripBooking update(TripBooking tripBooking) {
	    
		return tripBookingRepository.save(tripBooking);

	}
	
	public TripBooking getTripBookingById(int id)
	{
		return tripBookingRepository.getById(id);
	}

}
