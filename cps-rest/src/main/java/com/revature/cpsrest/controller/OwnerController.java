package com.revature.cpsrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);

	@Autowired
	private OwnerService ownerService;

	@GetMapping
	public List<Owner> getDepartmentList() {
		LOGGER.debug("{}", ownerService.list());
		return ownerService.list();
	}

}
