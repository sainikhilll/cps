package com.revature.cpsrest.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.OwnerPreference;
import com.revature.cpsrest.repository.OwnerPreferenceRepository;
@Service
public class OwnerPreferenceService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(OwnerPreference.class);
	 @Autowired
	    private OwnerPreferenceRepository ownerPreferenceRepository;
	 public List<OwnerPreference> List(){
		 LOGGER.info("Start");
		 return ownerPreferenceRepository.findAll();
		 
	 }
	 public OwnerPreference pref(OwnerPreference preference){
		 LOGGER.info("Start");
		 return ownerPreferenceRepository.save(preference);
		 
		 
	 }

}
