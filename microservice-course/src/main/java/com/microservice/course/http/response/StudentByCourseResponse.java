package com.microservice.course.http.response;

import com.microservice.course.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//manejo de respuestas persoalizadas de las peticiones
//cuando se haga la petición (findByIdCourse) desde cursos, esto son los datos que se le van a entregar
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Respuesta personalizada
public class StudentByCourseResponse {
  private String courseName;
  private String teacherName;
  private List<StudentDto> studentsDTOList;

}
