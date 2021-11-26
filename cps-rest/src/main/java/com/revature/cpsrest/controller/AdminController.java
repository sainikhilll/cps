package com.revature.cpsrest.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.dto.PassengerDto;
import com.revature.cpsrest.dto.TripBookingDto;
import com.revature.cpsrest.dto.TripDto;
import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.service.AdminService;

@RestController
//@RequestMapping
public class AdminController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AdminService adminservice;
	
	private List<TripDto> toTripDtoList(List<Trip> trips) {
		LOGGER.debug("toTripBooking called");
		List<TripDto> tripDtoList = new ArrayList<>();

		for (Trip trip : trips) {
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
			tripDto.setOwner(trip.getOwner());

			Set<TripBookingDto> tripBookingList = new HashSet<>();
			for (TripBooking tripBooking : trip.getTripBookings()) {

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
				// tripBookingDto.setRating(tripBooking.getRating());
				tripBookingDto.setOwnerRatingPassenger(tripBooking.getOwnerRatingPassenger());
				tripBookingDto.setPassengerRatingOwner(tripBooking.getPassengerRatingOwner());
				tripBookingDto.setPassengerReviewOwner(tripBooking.getPassengerReviewOwner());
				tripBookingDto.setNotificationStatus(tripBooking.getNotificationStatus());

				tripBookingList.add(tripBookingDto);
			}

			tripDto.setTripBookingList(tripBookingList);

			tripDtoList.add(tripDto);

		}
		return tripDtoList;
	}

	@GetMapping("/approvals")

	public List<Owner> ownerdetails() {

		return adminservice.list();

	}

	@GetMapping("/updates/{id}")
	public void update(@PathVariable int id) {

		Owner owner = adminservice.getOwner(id);

		owner.setStatus("Approved");
		adminservice.update(owner);
	}

	@GetMapping("/rejects/{id}")
	public void reject(@PathVariable int id) {

		Owner owner = adminservice.getOwner(id);

		owner.setStatus("Rejected");
		adminservice.update(owner);
	}

	@GetMapping("/trips")
	public List<TripDto> allTrips() {
		LOGGER.info("View Trip Started");
		return toTripDtoList(adminservice.trips());
	}

	@GetMapping("/completedTrips")
	public List<TripDto> allCompletedTrips() {
		LOGGER.info("View Trip Started");
		return toTripDtoList(adminservice.completedTrips());
	}

	@GetMapping("/canceltrips/{id}")
	public void canceltrips(@PathVariable int id) {
		LOGGER.info("CancelTrip Started");
		Trip trip = adminservice.getTripId(id);
		trip.setStatus("Called Off");
		adminservice.tripStatus(trip);

		List<TripBooking> tripBooking = adminservice.getTripBooking(id);
		for (TripBooking tripBook : tripBooking) {
			tripBook.setStatus("Called Off");
			adminservice.tripBookingStatus(tripBook);
		}

	}

	@GetMapping("/blackList/{id}")
	public void blackList(@PathVariable int id) {
		Owner owner = adminservice.getOwner(id);
		owner.setStatus("BlackList");
		owner.getUser().setBlacklisted('Y');
		adminservice.update(owner);
	}

	@GetMapping("/undoBlackList/{id}")
	public void undoBlackList(@PathVariable int id) {

		Owner owner = adminservice.getOwner(id);
		owner.setStatus("Pending");
		owner.getUser().setBlacklisted('N');
		adminservice.update(owner);
	}

}
