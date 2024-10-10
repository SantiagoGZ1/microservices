package com.microservice.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ya que student es un entity no se puede recibir en StudentClient
//para eso creamos un DTO (objeto de tranferencia de datos.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentDto {

  private String name;
  private String lastName;
  private String email;
  private Long courseId;
}