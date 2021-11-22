package com.revature.cpsrest.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.cpsrest.model.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	@Query("select p from Passenger p inner join fetch p.user ")
	List<Passenger> getpassenger();

}
