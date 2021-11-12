package com.revature.cpsrest.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.repository.OwnerRepository;

@Service
@Transactional

public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	public Owner getById(int id) {
		Optional<Owner> result = ownerRepository.findById(id);
		return result.get();
	}

	public void save(Owner owner) {
		ownerRepository.save(owner);
	}

	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}
	public Owner getOwnerByUserId (int userId) {
		return ownerRepository.getOwnerByUserId(userId);
	}

}
