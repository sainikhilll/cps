package com.revature.cpsrest.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.repository.PassengerRepository;

@Service
@Transactional
public class PassengerService {
private static final Logger LOGGER = LoggerFactory.getLogger(PassengerService.class);
@Autowired
private PassengerRepository passengerRepository;
public List<Passenger> list(){
	

return passengerRepository.getpassenger();
}
}