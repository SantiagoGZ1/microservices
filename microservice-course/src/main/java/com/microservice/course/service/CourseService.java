package com.microservice.course.service;

import com.microservice.course.persistence.CourseRepositery;
import entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService{

  @Autowired
  CourseRepositery courseRepositery;

  @Override
  public List<Course> findAll() {
    return (List<Course>) courseRepositery.findAll();
  }

  @Override
  public Course findById(Long id) {
    return courseRepositery.findById(id).orElseThrow();
  }

  @Override
  public void save(Course course) {
    courseRepositery.save(course);
  }
}
