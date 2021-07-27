package com.amdocs.learnzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.learnzone.models.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
