package com.Springproject.CourseApi.Services;

import java.util.List;
import java.util.Optional;

import com.Springproject.CourseApi.Entity.Course;

public interface CourseService {

	List<Course> getCourses();
	Optional<Course> getCourseById(long id);
	void deleteCourseById(long id);
	void updateCourse(Course uc);
	Course addCourse(Course course);
}
