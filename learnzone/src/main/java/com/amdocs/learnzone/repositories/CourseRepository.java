package com.amdocs.learnzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amdocs.learnzone.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	@Query("SELECT c FROM Course c WHERE c.id = ?1")
	Course findByCourseId(long courseId); 
}
