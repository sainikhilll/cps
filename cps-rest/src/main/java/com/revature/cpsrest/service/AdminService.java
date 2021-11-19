package com.revature.cpsrest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.Trip;
import com.revature.cpsrest.repository.AdminRepository;
import com.revature.cpsrest.repository.OwnerRepository;



@Service
public class AdminService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);
	
	@Autowired
	private AdminRepository adminrepository;
	
	@Autowired
	private OwnerRepository ownerrepository;
	
	@Autowired
	
	
	public List<Owner> list() {
		LOGGER.info("Start");
		return adminrepository.getPendingOwner();
	}
	public void update(Owner owner)
	{
		adminrepository.save(owner);
	}
	public Owner  getOwner(int id) {
		return ownerrepository.getById(id);
		
	}
	
	public List<Trip> trips(){
		LOGGER.info("Start");
		return adminrepository.getTrip();
	}
	
}
