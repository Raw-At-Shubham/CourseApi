package com.Springproject.CourseApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springproject.CourseApi.Entity.Course;

public interface CourseDao extends JpaRepository<Course,Long>{

}
