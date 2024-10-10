package com.microservice.student.service;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements IStudentService{
//Implements: implmento de los metodos abstractos de la interfaz

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
        //esto nos devuelve un optional, usamos orElseThrow por si no lo encuntra lanza un error

        /*otra opción para manejar el optional
        public Fare getFare(Integer id) {
            Optional<Fare> fareOptional = fareRepository.findById(id);
            if (fareOptional.isPresent()) {
                return fareOptional.get();
            }*/
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentRepository.findAllByCourseId(idCourse);
    }
}
