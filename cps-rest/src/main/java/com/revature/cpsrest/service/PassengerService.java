package com.revature.cpsrest.service;

import javax.transaction.Transactional;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.repository.PassengerRepository;
import com.revature.cpsrest.repository.UserRepository;

@Service
@Transactional
public class PassengerService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PassengerRepository passengerRepository;
	
	public void save(Passenger passenger) {
		userRepository.save(passenger.getUser());
		passengerRepository.save(passenger);
		
		
	}

	public Passenger getPassengerById(int userId) {
		return passengerRepository.getPassengerByUserId(userId);

	}

	public void update(Passenger passenger) {

		passengerRepository.save(passenger);
		
	}
	public Passenger getPassenger(int id) {

		return passengerRepository.getById(id);

	}

	public List<Passenger> list() {

		return passengerRepository.getpassenger();
	}
}
