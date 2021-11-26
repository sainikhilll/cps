package com.revature.cpsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.OwnerRating;

@Repository
public interface OwnerRatingRepository extends JpaRepository<OwnerRating, Integer> {

}
