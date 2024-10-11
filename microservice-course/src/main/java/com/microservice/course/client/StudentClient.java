package com.microservice.course.client;

import com.microservice.course.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//configurar cliente
@FeignClient(name = "msvc-student", url = "localhost:8090/api/student")
//microservicio al que se va a hacer la consulta

public interface StudentClient {
  //especificación de endpoint a consumir
  //estudiantes del curso 1.
  //se trae los estudiantes de msvc students y trae el curso
  @GetMapping("/search-by-course/{idCourse}")
  List<StudentDto> findAllStudentByCourse(@PathVariable Long idCourse);
  //findAllStudentByCourse consulta el msvc de student
}
