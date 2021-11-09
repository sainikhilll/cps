package com.revature.cpsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.cpsrest.model.User;


@Repository
public interface PasswordRepository extends JpaRepository<User, Integer> {
	 User findByEmailAndPassword(String email,String password);


}
