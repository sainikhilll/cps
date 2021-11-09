package com.revature.cpsrest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.cpsrest.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
