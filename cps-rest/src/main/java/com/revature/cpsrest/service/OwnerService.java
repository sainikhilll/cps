package com.revature.cpsrest.service;
import java.util.Optional;
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
		Integer id = owner.getId();
		Owner own = ownerRepository.findById(id).get();
		own.setName(owner.getName());
		own.setAddress(owner.getAddress());
		own.setMobile(owner.getMobile());
		own.setLicenceNumber(owner.getLicenceNumber());
		own.setLicenceUrl(owner.getLicenceUrl());
		own.setAadharNumber(owner.getAadharNumber());
		own.setAadharUrl(owner.getAadharUrl());
		return ownerRepository.save(own);
	}

}
