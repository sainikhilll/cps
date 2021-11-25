package com.revature.cpsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.OwnerRating;

@Repository
//	@Query("select o from OwnerRating o where o.owner.id = :ownerId")
//	public List<OwnerRating> getOwnerRatingsByOwnerId(@Param("ownerId") int ownerId);

public interface OwnerRatingRepository extends JpaRepository<OwnerRating, Integer>{
	@Query("select o from OwnerRating o where owner_id = :ownerId")
	List<OwnerRating> getRatings(@Param("ownerId") int ownerId);
}
























