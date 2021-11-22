package com.revature.cpsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.TripBooking;

@Repository
public interface OwnerNotificationsRepository extends JpaRepository<TripBooking,Integer>  {	
	@Query("select tb from TripBooking tb inner join fetch tb.trip t inner join fetch tb.passenger p where t.owner.id = :ownerId")
	List<TripBooking> getTripBookings(@Param("ownerId") int ownerId);
}
