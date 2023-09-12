package com.Springproject.CourseApi.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springproject.CourseApi.Entity.Course;
import com.Springproject.CourseApi.Services.CourseService;

@RestController
public class MyController {
	@Autowired
 private CourseService courseService;
	@GetMapping("/courses")
public List<Course> getCourses() {
	List<Course> courses = this.courseService.getCourses();
	return courses;
}
	@GetMapping("/courses/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable("id") int id) {
		
		Optional<Course>c= this.courseService.getCourseById(id);
		 if(c.isPresent())
				return new ResponseEntity<>(c,HttpStatus.OK);
			return new ResponseEntity<>("No course with this ID available",HttpStatus.NOT_FOUND);
		
	}
	@DeleteMapping("/courses/{id}")
	public void deleteCourseById(@PathVariable("id") long id) {
		
		this.courseService.deleteCourseById(id);
	
	}
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course uc) {
		
		this.courseService.updateCourse(uc);
		return uc;
	}
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		this.courseService.addCourse(course);
		return course;
	}
	
}
