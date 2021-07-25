package com.amdocs.learnzone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amdocs.learnzone.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email); 
}
