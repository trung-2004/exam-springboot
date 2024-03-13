package com.example.ExamSpringBoot.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateUser {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Age is required")
    private Integer age;

    @NotEmpty(message = "Salary is required")
    private Double salary;
}
