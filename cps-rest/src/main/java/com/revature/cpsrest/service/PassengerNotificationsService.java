package com.revature.cpsrest.service;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.cpsrest.controller.PassengerNotificationsController;
import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.repository.PassengerNotificationsRepository;
import com.revature.cpsrest.repository.PassengerRepository;

@Service
@Transactional
public class PassengerNotificationsService {
	private final Logger LOGGER = LoggerFactory.getLogger(PassengerNotificationsController.class);

	@Autowired
	private PassengerNotificationsRepository passengerNotificationsRepository;
	@Autowired
	private PassengerRepository passengerRepository;

	public List<TripBooking> getTripBookings(int passengerId) {
		LOGGER.info("Passenger Notification Service Starts");
		Passenger passenger = passengerRepository.getPassengerByUserId(passengerId);
		return passengerNotificationsRepository.getTripBookings(passenger.getId());
	}

	public void save(TripBooking tripBooking) {
		passengerNotificationsRepository.save(tripBooking);
	}
}
