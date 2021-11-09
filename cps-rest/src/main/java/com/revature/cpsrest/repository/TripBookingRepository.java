package com.revature.cpsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.TripBooking;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking,Integer>{
	
}




