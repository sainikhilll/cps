package com.revature.cpsrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.repository.PassengerRepository;

@Service
@Transactional
public class PassengerService {
	@Autowired
	private PassengerRepository passengerRepository;
	
	public Passenger getPassengerById(int userId) {
		return passengerRepository.getPassengerByUserId(userId);
	}

}
