package com.revature.cpsrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cpsrest.model.OwnerRating;
import com.revature.cpsrest.repository.OwnerRatingRepository;;

@Service
@Transactional
public class OwnerRatingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerService.class);

	@Autowired
	private OwnerRatingRepository ownerRatingRepositorye;
//	@Autowired
//	private TripRepository tripRepository;

}
