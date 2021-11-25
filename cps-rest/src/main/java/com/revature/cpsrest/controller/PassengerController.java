package com.revature.cpsrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.model.User;
import com.revature.cpsrest.service.PassengerService;
import com.revature.cpsrest.service.UserService;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PassengerController.class);

	@Autowired
	private PassengerService passengerService;

	@Autowired
	private UserService userService;

	@PostMapping
	public void create(@RequestBody Passenger passenger) {

		LOGGER.debug("{}", passenger);
		User user1 = new User();
		user1.setEmail(passenger.getUser().getEmail());
		user1.setPassword(passenger.getUser().getPassword());
		user1.setRole("passenger");
		LOGGER.debug("{}", user1);
		User user2 = userService.saveUser(user1);
		LOGGER.debug("id:{}", user2.getId());
		passenger.setUser(user2);
		passengerService.save(passenger);
	}

	@GetMapping
	public List<Passenger> getPassengerList() {

		//LOGGER.debug("{}", passengerService.list());

		return passengerService.list();
	}
	@GetMapping("/passengerBlackList/{id}")
	public void blackList(@PathVariable int id) {

		Passenger passenger=passengerService.getPassenger(id);
		
		passenger.getUser().setBlacklisted('Y');
		passengerService.update(passenger);
	}

}