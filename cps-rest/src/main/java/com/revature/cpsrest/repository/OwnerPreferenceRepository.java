package com.revature.cpsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.OwnerPreference;
@Repository
public interface OwnerPreferenceRepository extends JpaRepository<OwnerPreference, Integer>{

}
