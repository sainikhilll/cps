package com.revature.cpsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Owner;

@Repository
	public interface OwnerRepository extends JpaRepository<Owner, Integer> {
		@Query("Select o from Owner o Where o.user.id = :userId")
		Owner getOwnerByUserId (@Param("userId") int userId);


}
