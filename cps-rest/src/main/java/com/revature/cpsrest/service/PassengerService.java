package com.revature.cpsrest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.repository.PassengerRepository;

@Service
@Transactional

public class PassengerService {
	@Autowired

	private PassengerRepository passengerRepository;

	public void save(Passenger passenger) {
		passengerRepository.save(passenger);
	}

}
