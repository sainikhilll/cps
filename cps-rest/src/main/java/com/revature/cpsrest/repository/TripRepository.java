package com.revature.cpsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer>{
	@Query("Select o from Owner o where o.user.id = :userId")
	Owner getOwnerByUserId(@Param("userId") int userId); 
}
