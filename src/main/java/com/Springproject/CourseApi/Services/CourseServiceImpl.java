package com.Springproject.CourseApi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springproject.CourseApi.Dao.CourseDao;
import com.Springproject.CourseApi.Entity.Course;
@Service
public class CourseServiceImpl implements CourseService {
@Autowired
private CourseDao courseDao;
//	List<Course> courses;
//	public CourseServiceImpl() {
//		courses=new ArrayList<>();
//		courses.add(new Course(12,"Java Core","This is Java course Description"));
//		courses.add(new Course(13,"Spring Boot","This is Java Spring Boot Description"));
//
//	}
//	
//	public List<Course> getCourses() {
//		
//		return courses;
//	}
//
//	@Override
//	public Course getCourseById(int id) {
//		Course course = courses.stream().filter(c->c.getId()==id).findFirst().get();
//	return course; 
//	}
//
//	@Override
//	public void deleteCourseById(long id) {
//		courses=courses.stream().filter(c->c.getId()!=id).collect(Collectors.toList());
//		
//	}
//
//	@Override
//	public void updateCourseById(Course uc,int id) {
//		   courses.stream().map(c->{
//			if(c.getId()==id)
//		{
//				c.setId(uc.getId());
//				c.setTitle(uc.getTitle());
//				c.setDescription(uc.getDescription());
//		
//		}return c;
//				}).collect(Collectors.toList());
//	
//	}
//	

@Override
public List<Course> getCourses() {
	List<Course> courses = this.courseDao.findAll();
	return courses;
}

@Override
public Optional<Course> getCourseById(long id) {
	Optional<Course> c = this.courseDao.findById(id);
	return c;
} 


@Override
public void deleteCourseById(long id) {
	this.courseDao.deleteById(id);
	
}

@Override
public void updateCourse(Course uc) {
	this.courseDao.save(uc);
	
}

@Override
public Course addCourse(Course course) {
	this.courseDao.save(course);
	return course;
	
}

}
