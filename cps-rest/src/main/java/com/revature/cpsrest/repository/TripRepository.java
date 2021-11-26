package com.revature.cpsrest.repository;


import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.service.TripService;
@Repository
public interface TripRepository extends JpaRepository<Trip,Integer> {
	static final Logger LOGGER = LoggerFactory.getLogger(TripService.class);
	
	@Query("Select t from Trip t inner join fetch t.owner o where origin = :origin and destination = :destination and date = :date and o.status='Approved'" )
	List<Trip> getTrips(@Param("origin") String origin,@Param("destination") String destination,@Param("date") Date date);
	
	@Query("Select o from Owner o where o.user.id = :userId")
	Owner getOwnerByUserId(@Param("userId") int userId); 
	
	//@Query("SELECT t from TripBooking tb inner join fetch tb.trip t where t.date < sysdate() and tb.passenger.id = :passengerId ")
	@Query("SELECT t from Trip t inner join fetch t.tripBookings tb where t.date < sysdate() and tb.passenger.id = :passengerId")
	public Set<Trip> getCompletedTrips(@Param("passengerId") int passengerId);
}



//select * from trip t inner join trip_bookings tb on t.id = tb.trip_id where date < sysdate() and passenger_id = 1;