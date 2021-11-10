package com.revature.cpsrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Owner;

import com.revature.cpsrest.repository.OwnerRepository;

@Service
@Transactional
public class OwnerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerService.class);

	@Autowired
	private OwnerRepository ownerRepository;

	public List<Owner> list() {
		return ownerRepository.getOwners();
	}

}
