package com.amdocs.learnzone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amdocs.learnzone.models.Course;
import com.amdocs.learnzone.models.Feedback;
import com.amdocs.learnzone.services.CourseService;
import com.amdocs.learnzone.services.FeedbackService;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/courses/{courseId}/feedback")
	public String viewFeedbackForm(@PathVariable("courseId") Long courseId, Model model) {
		model.addAttribute("feedback", new Feedback());
		Course course = courseService.getCourse(courseId);
		model.addAttribute("course", course);
		return "feedback_form";
	}
	
	@PostMapping("/courses/{courseId}/feedback/add")
	public String addFeedbackToCourse(@ModelAttribute("feedback") Feedback feedback, @PathVariable("courseId") Long courseId) {
		feedbackService.addFeedback(feedback, courseId);
		return "redirect:/courses/" + courseId; 
	}
}
