package com.revature.cpsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.cpsrest.model.OwnerPreference;

public interface OwnerPreferenceRepository extends JpaRepository<OwnerPreference, Integer> {

}
