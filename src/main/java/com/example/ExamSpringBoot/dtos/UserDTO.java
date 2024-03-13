package com.example.ExamSpringBoot.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;

    private Integer age;

    private Double salary;
}
