package com.revature.cpsrest.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.dto.PassengerDto;
import com.revature.cpsrest.dto.TripBookingDto;
import com.revature.cpsrest.dto.TripDto;
import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.service.PassengerService;
import com.revature.cpsrest.service.TripBookingService;
import com.revature.cpsrest.service.TripService;

@RestController
@RequestMapping("/trip-bookings")
public class TripBookingController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TripBookingService tripBookingService;
	@Autowired
	private TripService tripService;
	@Autowired
	private PassengerService passengerService;
	
	private Set<TripDto> toTripBookingDto(Set<Trip> trips) {
		LOGGER.debug("toTripBooking called");
		Set<TripDto> tripDtoList = new HashSet<>();
		
		for(Trip trip: trips) {
//			LOGGER.info("{}", trip);
			TripDto tripDto = new TripDto();
			
			tripDto.setId(trip.getId());
			tripDto.setOrigin(trip.getOrigin());
			tripDto.setDestination(trip.getDestination());
			tripDto.setDepartureTime(trip.getDepartureTime());
			tripDto.setCarType(trip.getCarType());
			tripDto.setPrice(trip.getPrice());
			tripDto.setDate(trip.getDate());
			tripDto.setNumberOfPassengers(trip.getNumberOfPassengers());
			tripDto.setNumberOfSeatsAvailable(trip.getNumberOfSeatsAvailable());
			tripDto.setStatus(trip.getStatus());
			
			Set<TripBookingDto> tripBookingList = new HashSet<>();
			for(TripBooking tripBooking: trip.getTripBookings()) {

				TripBookingDto tripBookingDto = new TripBookingDto();
				PassengerDto passengerDto = new PassengerDto();
				
				
				passengerDto.setId(tripBooking.getPassenger().getId());
				passengerDto.setName(tripBooking.getPassenger().getName());
				passengerDto.setMobileNumber(tripBooking.getPassenger().getMobileNumber());
				passengerDto.setDateOfBirth(tripBooking.getPassenger().getDateOfBirth());
				
				tripBookingDto.setId(tripBooking.getId());
				tripBookingDto.setPassenger(passengerDto);
				tripBookingDto.setSeatsBooked(tripBooking.getSeatsBooked());
				tripBookingDto.setStatus(tripBooking.getStatus());
				tripBookingDto.setRating(tripBooking.getRating());
				
				tripBookingList.add(tripBookingDto);
			}
			
			tripDto.setTripBookingList(tripBookingList);
			

			
			tripDtoList.add(tripDto);
			
		}
		return tripDtoList;
	}

	@PostMapping
	public void create(@RequestBody TripBooking booking) {
		Passenger p = passengerService.getPassengerById(booking.getPassenger().getUser().getId());
		LOGGER.debug("passenger Id: {}", p);
		booking.getPassenger().setId(p.getId());
		;
		tripBookingService.save(booking);
		Optional<Trip> tripUpdated = tripService.getById(booking.getTrip().getId());
//	Trip t=null;
		tripUpdated.ifPresent(t -> {
			t.setNumberOfSeatsAvailable(t.getNumberOfSeatsAvailable() - booking.getSeatsBooked());
		});
		tripUpdated.ifPresent(l -> {
			tripService.save(l);
		});
//	
	}
	
	@GetMapping("/{userId}")
    public Set<TripDto> getTripBookingsByOwnerId(@PathVariable int userId) {
		LOGGER.debug("***********Trip Id: {}",userId);
		Set<Trip> trips = tripBookingService.getTripBookings(userId);
		LOGGER.debug("after service");
    	Set<TripDto> tripBookings =  toTripBookingDto(trips);
    	LOGGER.debug("after function");
    	return tripBookings;
    }
	
	@PutMapping("/passengerRatings")
	public void updateRating(@RequestBody TripBooking tripBooking) {
		LOGGER.debug("{}", tripBooking);
		TripBooking rating = tripBookingService.getTripBooking(tripBooking.getId());
		rating.setRating(tripBooking.getRating());
		tripBookingService.save(rating);
	}
}
