package com.revature.cpsrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.OwnerRating;
import com.revature.cpsrest.repository.OwnerRatingRepository;

@Service
@Transactional
public class OwnerRatingService {
	
	@Autowired
	private OwnerRatingRepository ownerRatingRepository;
	
	public List<OwnerRating> getOwnerRatingsByOwnerID(int ownerId){
		return ownerRatingRepository.getOwnerRatingsByOwnerId(ownerId);
	}
}
