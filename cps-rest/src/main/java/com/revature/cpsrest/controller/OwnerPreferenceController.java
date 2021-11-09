package com.revature.cpsrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.OwnerPreference;
import com.revature.cpsrest.service.OwnerPreferenceService;

@RestController
@RequestMapping("/ownerpreferences")
public class OwnerPreferenceController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerPreferenceController.class);
	@Autowired
    private OwnerPreferenceService ownerPreferenceService;
	@GetMapping
	public List<OwnerPreference> getOwnerPreferenceList(){
		return ownerPreferenceService.List();
	}
	@PostMapping
	public void postOwnerPreferenceList(@RequestBody OwnerPreference preference){
		ownerPreferenceService.pref(preference);
		
	}
	
	
}
