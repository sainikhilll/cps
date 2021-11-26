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
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.service.PassengerNotificationsService;

@RestController
@RequestMapping("/passenger_notifications")
public class PassengerNotificationsController {
	private final Logger LOGGER = LoggerFactory.getLogger(PassengerNotificationsController.class);

	@Autowired
	private PassengerNotificationsService passengerNotificationsService;
	
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
			
			tripBookingList1.add(tripBookingDto);
		}
		
		return tripBookingList1;
	}

	@GetMapping("/{passengerId}")
	public List<TripBookingDto> getTripBookings(@PathVariable int passengerId) {
		LOGGER.info("Passenger Notifications Controller Starts");
		LOGGER.debug("passenger id: {}", passengerId);
		return  toTripBookingDto(passengerNotificationsService.getTripBookings(passengerId));
	}

	@PutMapping
	public void update(@RequestBody TripBooking tripBooking) {
		passengerNotificationsService.save(tripBooking);
	}
}
