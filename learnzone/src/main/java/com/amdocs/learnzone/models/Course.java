package com.amdocs.learnzone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(
			name = "sequence-generator",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name = "sequence_name", value = "course_sequence"),
					@Parameter(name = "initial_value", value = "1001"),
					@Parameter(name = "increment_size", value = "1")
			}
		)
	private long courseId;
	@Column(name = "course_name", nullable = false)
	private String courseName;
	@Column(name = "course_desc", nullable = false)
	private String courseDesc;
	@Column(name = "course_fees", nullable = false)
	private String courseFees;
	@Column(name = "course_resource", nullable = false)
	private String courseResource;
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesp) {
		this.courseDesc = courseDesp;
	}
	public String getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(String courseFees) {
		this.courseFees = courseFees;
	}
	public String getCourseResource() {
		return courseResource;
	}
	public void setCourseResource(String courseResource) {
		this.courseResource = courseResource;
	}
}
