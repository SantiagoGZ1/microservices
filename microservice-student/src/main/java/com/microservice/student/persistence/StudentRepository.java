package com.microservice.student.persistence;

import com.microservice.student.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
// CrudRepository es más basico que JpaRepository, ya que solo permite el CRUD basico (Create, Read, Update, Delete)

    /*hay dos formas de crear querys.
    1 con el nombre del motodo
    2. con @query en formato sql*/

    /*@Query("SELECT s FROM Student s WHERE s.courseId = :idCourse")
    List<Student> findAllStudentCourse(Long idCourse);*/


    List<Student> findAllByCourseId(Long idCourse);
}
