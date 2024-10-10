package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

  @Autowired
  private IStudentService studentService;

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED) //tipo de retorno
  public void saveStudent(@RequestBody Student student) {
    studentService.save(student);
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Student student = studentService.findById(id);
    //manejo de dato no encontrado
    if (student == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
    }
    return ResponseEntity.ok(studentService.findById(id));
  }
/*<?> para no especificar el tipo
Por ejemplo, si tienes un método que puede devolver un valor de cualquier tipo, y no te importa el tipo específico, puedes usar <?>.*/

  @GetMapping("/all")
  public ResponseEntity<?> findAllStudents() {
      List<Student> students = studentService.findAll();
      if (students.isEmpty()){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are not students");
      }
      return ResponseEntity.ok(students);
  }


}
