package com.microservice.course.persistence;

import entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositery extends CrudRepository<Course, Long> {

}
