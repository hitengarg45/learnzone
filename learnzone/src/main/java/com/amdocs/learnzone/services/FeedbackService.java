package com.amdocs.learnzone.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.learnzone.models.Course;
import com.amdocs.learnzone.models.Feedback;
import com.amdocs.learnzone.repositories.CourseRepository;
import com.amdocs.learnzone.repositories.FeedbackRepository;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	CourseService courseService;
	
	public List<Feedback> getAllFeedbacksByCourseIDS(Long courseId){
		return new ArrayList<>();
	}
	
	public void addFeedback(Feedback feedback, Long courseId) {
		Course course = courseService.getCourse(courseId);
		feedback.setCourse(course);
		feedbackRepository.save(feedback);
		course.getFeedbacks().add(feedback);
		courseService.addCourse(course);
	}
}
