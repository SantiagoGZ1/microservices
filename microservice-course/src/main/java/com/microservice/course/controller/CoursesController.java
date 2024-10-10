package com.microservice.course.controller;

import com.microservice.course.service.CourseService;
import com.microservice.course.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CoursesController {

  @Autowired
  CourseService courseService;

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED) //tipo de retorno
  public void saveCourse(@RequestBody Course course) {
    courseService.save(course);
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Course student = courseService.findById(id);
    //manejo de dato no encontrado
    if (student == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
    }
    return ResponseEntity.ok(courseService.findById(id));
  }

  @GetMapping("/all")
  public ResponseEntity<?> findAllStudents() {
    List<Course> courses = courseService.findAll();
    if (courses.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are not students");
    }
    return ResponseEntity.ok(courses);
  }

  //endpoint de petición de metodo heredado de msvc student
  @GetMapping("/serch-students/{idCourse}")
  public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse){

    return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));

  }

}
