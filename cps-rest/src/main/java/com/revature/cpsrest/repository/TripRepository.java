package com.revature.cpsrest.repository;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.service.TripService;
@Repository
public interface TripRepository extends JpaRepository<Trip,Integer> {
	static final Logger LOGGER = LoggerFactory.getLogger(TripService.class);
     
	
	@Query("Select t from Trip t inner join fetch t.owner o where origin = :origin and destination = :destination and date = :date and o.status='Approved'" )
	List<Trip> getTrips(@Param("origin") String origin,@Param("destination") String destination,@Param("date") Date date);
	
	
}
