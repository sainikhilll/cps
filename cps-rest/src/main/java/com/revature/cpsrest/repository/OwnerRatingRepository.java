package com.revature.cpsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.OwnerRating;
import com.revature.cpsrest.model.Trip;

@Repository
public interface OwnerRatingRepository extends JpaRepository<OwnerRating, Integer> {
	

	
	
	
}

