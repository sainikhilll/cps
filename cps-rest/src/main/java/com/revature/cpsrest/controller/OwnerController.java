package com.revature.cpsrest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.model.OwnerPreference;
import com.revature.cpsrest.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);
	
	@Autowired
	private OwnerService ownerService;

	@PutMapping
	public Owner update(@RequestBody Owner owner) {
		return ownerService.update(owner);
	}

	@GetMapping("/preferences/{id}")
	public OwnerPreference getOwnerPreference(@PathVariable int id) {
		Owner op = ownerService.getOwnerByUserId(id);
		return op.getOwnerPreference();
	}

	@GetMapping("/user/{id}")
	public Owner getOwner(@PathVariable int id) {
		return ownerService.getOwnerByUserId(id);
	}

	@GetMapping
	public List<Owner> getDepartmentList() {
		LOGGER.debug("{}", ownerService.list());
		return ownerService.list();

	}

}
