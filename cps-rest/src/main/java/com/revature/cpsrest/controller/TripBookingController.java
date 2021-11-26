package com.revature.cpsrest.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.repository.OwnerRepository;
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
	@Autowired
	private OwnerRepository ownerRepository;
	
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
				tripBookingDto.setOwnerRatingPassenger(tripBooking.getOwnerRatingPassenger());
				tripBookingDto.setPassengerRatingOwner(tripBooking.getPassengerRatingOwner());
				tripBookingDto.setPassengerReviewOwner(tripBooking.getPassengerReviewOwner());
				
				tripBookingList.add(tripBookingDto);
			}
			
			tripDto.setTripBookingList(tripBookingList);
			

			
			tripDtoList.add(tripDto);
			
		}
		return tripDtoList;
	}
	
	public List<TripBookingDto> toTripBookingDto(List<TripBooking> tripBookingList) {
		List<TripBookingDto> tripBookingList1 = new ArrayList<>();
		for(TripBooking tripBooking: tripBookingList) {

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
			tripBookingDto.setOwnerRatingPassenger(tripBooking.getOwnerRatingPassenger());
			tripBookingDto.setPassengerRatingOwner(tripBooking.getPassengerRatingOwner());
			tripBookingDto.setPassengerReviewOwner(tripBooking.getPassengerReviewOwner());
			
			tripBookingList1.add(tripBookingDto);
		}
		
		return tripBookingList1;
	}

	@PostMapping
	public void create(@RequestBody TripBooking booking) {
		Passenger p = passengerService.getPassengerById(booking.getPassenger().getUser().getId());
		LOGGER.debug("passenger Id: {}", p);
		booking.getPassenger().setId(p.getId());
		;
		tripBookingService.save(booking);
		Optional<Trip> tripUpdated = tripService.getById(booking.getTrip().getId());

		tripUpdated.ifPresent(t -> {
			t.setNumberOfSeatsAvailable(t.getNumberOfSeatsAvailable() - booking.getSeatsBooked());
		});
		tripUpdated.ifPresent(l -> {
			tripService.save(l);
		});

	}
	@GetMapping("/ownerRatings/{ownerId}")
	public List<TripBookingDto> getOwnerRatingsByOwnerId(@PathVariable int ownerId){
		//Owner o = ownerService.getOwnerByUserId(userId);
		return toTripBookingDto(tripBookingService.getOwnerRatingsByOwnerID(ownerId));
	}
	@GetMapping("/ownerratingsuser/{userId}")
	public List<TripBookingDto> getOwnerRatings(@PathVariable int userId){
		Owner o = ownerRepository.getOwnerByUserId(userId);
		LOGGER.info("In tripbooking {}",o);
		return toTripBookingDto(tripBookingService.getOwnerRatingsByOwnerID(o.getId()));
	}
	
	@PutMapping
	public void updateRatingAndReview(@RequestBody TripBooking tripBooking)
	{
		LOGGER.info("{}",tripBooking);
		TripBooking tb = tripBookingService.getTripBookingById(tripBooking.getId());
		Passenger p = passengerService.getPassengerById(tripBooking.getPassenger().getUser().getId());
		tb.setPassengerRatingOwner(tripBooking.getPassengerRatingOwner());
		tb.setPassengerReviewOwner(tripBooking.getPassengerReviewOwner());
		tripBookingService.update(tripBooking);
		
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
		rating.setOwnerRatingPassenger(tripBooking.getOwnerRatingPassenger());
		tripBookingService.save(rating);
	}
}
