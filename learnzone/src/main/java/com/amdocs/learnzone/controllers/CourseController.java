package com.amdocs.learnzone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.learnzone.models.Course;
import com.amdocs.learnzone.services.CourseService;

@Controller
public class CourseController {
	
	@Autowired 
	private CourseService courseService; 
	
	@GetMapping("/courses")
	public String getAllCourses(Model model) {
		List<Course> courses = courseService.getAllCourses();
		model.addAttribute("courses", courses);
		return "all_courses";
	}
	
	@GetMapping("/courses/{courseId}")
	public String viewCourse(@PathVariable("courseId") Long courseId, Model model) {
		Course course = courseService.getCourse(courseId);
		model.addAttribute("course", course);
		return "course";
	}
	
	@GetMapping("/courses/add-course-form")
	public String viewAddCourseForm(Model model) {
		model.addAttribute("course", new Course());
		return "add_course_form";
	}
	
	@PostMapping("/courses/add-course")
	public String addCourse(@ModelAttribute("course") Course course) {
		courseService.addCourse(course);
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/update-course-form/{courseId}")
	public String viewUpdateCourseForm(@PathVariable("courseId") Long courseId, Model model) {
		Course course = courseService.getCourse(courseId);
		model.addAttribute("course", course);
		return "update_course_form";
	}
	
	@PostMapping("/courses/update-course")
	public String updateCourse(@ModelAttribute("course") Course course) {
		courseService.updateCourse(course);
		return "redirect:/courses/" + course.getCourseId();
	}
}
