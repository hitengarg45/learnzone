package com.amdocs.learnzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.learnzone.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
