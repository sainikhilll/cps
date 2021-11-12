package com.revature.cpsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	@Query("Select o from Passenger o Where o.user.id = :userId")
	Passenger getPassengerByUserId (@Param("userId") int userId);


}

