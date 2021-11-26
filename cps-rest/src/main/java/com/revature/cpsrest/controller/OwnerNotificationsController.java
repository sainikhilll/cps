package com.revature.cpsrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.dto.PassengerDto;
import com.revature.cpsrest.dto.TripBookingDto;
import com.revature.cpsrest.dto.TripDto;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.service.OwnerNotificationsService;

@RestController
@RequestMapping("/notifications")
public class OwnerNotificationsController {
	private final Logger LOGGER = LoggerFactory.getLogger(OwnerNotificationsController.class);

	@Autowired 
	private OwnerNotificationsService ownerNotificationsService;
	
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
			tripBookingDto.setNotificationStatus(tripBooking.getNotificationStatus());
			
			TripDto tripDto = new TripDto();
			Trip trip =tripBooking.getTrip();
			
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
			
			tripBookingDto.setTrip(tripDto);
			
			tripBookingList1.add(tripBookingDto);
		}
		
		return tripBookingList1;
	}
	
	@GetMapping("/{ownerId}")
	public List<TripBookingDto> getTripBookings(@PathVariable int ownerId){
		LOGGER.info("Owner Notifications Controller Starts");
		LOGGER.debug("owner id: {}", ownerId);
		return toTripBookingDto(ownerNotificationsService.getTripBookings(ownerId));
	}
	
	@PutMapping
	public void update(@RequestBody TripBooking tripBooking) {
		LOGGER.debug("TripBooking:{}",tripBooking);
		ownerNotificationsService.save(tripBooking);
	}
	
}
