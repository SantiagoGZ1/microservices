package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDto;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.CourseRepositery;
import com.microservice.course.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService{

  @Autowired
  CourseRepositery courseRepositery;

  @Autowired
  private StudentClient studentClient;
  //importación de la interface que conecta con el msvc student

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

  @Override
  public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
    //implementación del metodo DTO
    //consulta el curos
    Course course = courseRepositery.findById(idCourse).orElse(new Course()); //si no lo encuentra que cree un curso vacio

    //Obtener estudiantes consultando el microservcio de students.
    //configurando el cliente arriba, ya que el es el que se conecta con students
    List<StudentDto> studentsDTOList = studentClient.findAllStudentByCourse(idCourse);
    return StudentByCourseResponse.builder()
        .courseName(course.getName())
        .teacherName(course.getTeacher())
        .studentsDTOList(studentsDTOList)
        .build();//contruccion del objeto
  }
}
