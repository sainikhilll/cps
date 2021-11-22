package com.revature.cpsrest.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Passenger;
import com.revature.cpsrest.service.PassengerService;

@RestController
 @RequestMapping("/passengers")
 public class PassengerController{
 private static final Logger LOGGER = LoggerFactory.getLogger(PassengerController.class);
@Autowired
 private PassengerService passengerservice;

 @GetMapping
 public List<Passenger> getDepartmentList() {

LOGGER.debug("{}",passengerservice.list());

return passengerservice.list();
}
}