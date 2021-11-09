package com.revature.cpsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.Owner;


@Repository
public interface AdminRepository extends JpaRepository<Owner,Integer> {
	@Query("select o,u.email from Owner o inner join fetch o.user u where status ='Pending'")
	List<Owner> getPendingOwner();


}
