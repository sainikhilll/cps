package com.revature.cpsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.OwnerRating;
import com.revature.cpsrest.model.TripBooking;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking,Integer>{

//	@Query("UPDATE TripBooking ts SET ts.status = 'terminated' WHERE ts.trip.id = :tripId")
//     void updateStatus(@Param("tripId") int tripId);
	public List<TripBooking> getByTripId(int id);
	@Query("select tb from TripBooking tb inner join fetch tb.trip  where tb.trip.owner.id = :ownerId")
	public List<TripBooking> getOwnerRatingsByOwnerId(@Param("ownerId") int ownerId);

}




