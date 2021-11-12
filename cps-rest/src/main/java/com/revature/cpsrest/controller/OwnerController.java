package com.revature.cpsrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.OwnerPreference;
import com.revature.cpsrest.service.OwnerService;

@RestController
@RequestMapping("/owners")

public class OwnerController {
	@Autowired
	private OwnerService ownerService;

	@GetMapping("/preferences/{id}")
	public OwnerPreference getOwnerPreference(@PathVariable int id) {
		Owner op = ownerService.getOwnerByUserId(id);
		return op.getOwnerPreference();
	}

}
