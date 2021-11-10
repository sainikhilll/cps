package com.revature.cpsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

	 @Query("select o from Owner o inner join fetch o.user inner join fetch o.ownerPreference")
	 List<Owner> getOwners();
}
