package com.revature.cpsrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.controller.OwnerNotificationsController;
import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.TripBooking;
import com.revature.cpsrest.repository.OwnerNotificationsRepository;
import com.revature.cpsrest.repository.OwnerRepository;

@Service
@Transactional
public class OwnerNotificationsService {
	private final Logger LOGGER = LoggerFactory.getLogger(OwnerNotificationsController.class);
	
	@Autowired
	private OwnerNotificationsRepository ownerNotificationsRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	
	public List<TripBooking> getTripBookings(int ownerId){
		LOGGER.info("Owner Notification Service Starts");
		Owner owner = ownerRepository.getOwnerByUserId(ownerId);
		return ownerNotificationsRepository.getTripBookings(owner.getId());
	}
	public void save(TripBooking tripBooking) {
		ownerNotificationsRepository.save(tripBooking);
	}
//	public int getCount(int ownerId) {
//		Owner owner = ownerRepository.getOwnerByUserId(ownerId);
//		return ownerNotificationsRepository.getCount(owner.getId());
//	}
}
