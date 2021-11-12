
package com.revature.cpsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.revature.cpsrest.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where email=:email and password=:password")
	public User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	//User findByEmailAndPassword(String email, String password);
	
}