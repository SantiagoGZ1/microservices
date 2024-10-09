package com.microservice.student.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//data genera getters, setters, tostring,
@Entity
// Entity Se utiliza para marcar una clase como una entidad que se va a mapear a una tabla de base de datos.
@Builder
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "course_id")
    private Long courseId;
}
