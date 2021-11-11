package com.revature.cpsrest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.cpsrest.model.Owner;
import com.revature.cpsrest.repository.OwnerPreferenceRepository;
import com.revature.cpsrest.repository.OwnerRepository;
import com.revature.cpsrest.repository.UserRepository;

@Service
public class OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private OwnerPreferenceRepository ownerPreferenceRepository;
	
//	public List<Owner> list()
//	{
//		return ownerRepository.findAll();
//	}
//	
//	public Owner getById(int id)
//	{
//		Optional<Owner> result = ownerRepository.findById(id);
//		return result.get();
//	}
//	
	public void save(Owner owner)
	{
		userRepository.save(owner.getUser());
		ownerPreferenceRepository.save(owner.getOwnerPreference());
		ownerRepository.save(owner);
	}
	
//	public void delete(int id)
//	{
//		ownerRepository.deleteById(id);
//	}

}

