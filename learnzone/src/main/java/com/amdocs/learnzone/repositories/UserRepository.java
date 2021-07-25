package com.amdocs.learnzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.learnzone.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
