package com.revature.cpsrest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.repository.PassengerRepository;
import com.revature.cpsrest.repository.UserRepository;

@Service
@Transactional
public class PassengerService {
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private UserRepository userRepository;

	public void save(Passenger passenger) {
		userRepository.save(passenger.getUser());
		passengerRepository.save(passenger);
	}

	public Passenger getPassengerById(int userId) {
		return passengerRepository.getPassengerByUserId(userId);

	}

}
