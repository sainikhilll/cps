package com.revature.cpsrest.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.model.TripBooking;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {

	public List<TripBooking> getByTripId(int id);

	@Query("select tb from TripBooking tb inner join fetch tb.trip  where tb.trip.owner.id = :ownerId")
	public List<TripBooking> getOwnerRatingsByOwnerId(@Param("ownerId") int ownerId);

	@Query("select t from Trip t inner join fetch t.tripBookings tb inner join fetch tb.passenger p where t.owner.id = :ownerId")
	Set<Trip> getTripsbyOwnerId(@Param("ownerId") int ownerId);
}
