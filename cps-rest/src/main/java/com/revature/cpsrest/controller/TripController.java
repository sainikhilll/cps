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
import com.revature.cpsrest.service.PassengerService;
import com.revature.cpsrest.service.TripService;

@RestController
@RequestMapping("/trips")
public class TripController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TripService tripService;

	@Autowired
	private PassengerService passengerService;

	private Set<TripDto> toTripBookingDto(Set<Trip> trips) {
		LOGGER.debug("toTripBooking called");
		Set<TripDto> tripDtoList = new HashSet<>();

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

	
	private TripDto toTripBookingDtoBean(Trip trip) {
		LOGGER.debug("toTripBooking called");

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

		return tripDto;
	}

	@GetMapping("/{id}")
	public TripDto getTrip(@PathVariable int id) {
		LOGGER.debug("Trip Id: {}", id);
		return toTripBookingDtoBean(tripService.getById(id).get());
	}

	@PostMapping("/search")
	public List<TripDto> searchTrip(@RequestBody Trip trip) {
		LOGGER.debug("{}", trip);
		return toTripDtoList(tripService.passTrip(trip));
	}

	@PostMapping
	public void create(@RequestBody Trip trip) {
		LOGGER.info("Trip Controller Starts");
		LOGGER.debug("Trip: {}", trip);
		tripService.save(trip);
	}

	@GetMapping("/canceltrips/{id}")
	public void canceltrips(@PathVariable int id) {
		LOGGER.info("CancelTrip Started");
		Trip trip = tripService.getTripId(id);
		trip.setStatus("Cancelled");
		tripService.tripStatus(trip);
	}

	@GetMapping("/user/{id}")
	public Owner getOwner(@PathVariable int id) {
		return tripService.getOwnerByUserId(id);
	}

	@PutMapping("/update")
	public void updateTrip(@RequestBody Trip trip) {
		tripService.updateTrip(trip);
	}

	@GetMapping("/completed/{userId}")
	public Set<TripDto> getCompletedTripsOfPassenger(@PathVariable int userId) {
		Passenger p = passengerService.getPassengerById(userId);
		Set<Trip> trips = tripService.getCompletedTripsOfPassenger(p.getId());
		Set<TripDto> tripsDto = toTripBookingDto(trips);
		return tripsDto;

	}
}
