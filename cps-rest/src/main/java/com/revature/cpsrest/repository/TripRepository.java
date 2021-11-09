package com.revature.cpsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer>{
	
}
