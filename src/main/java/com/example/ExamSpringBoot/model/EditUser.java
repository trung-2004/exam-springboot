package com.example.ExamSpringBoot.model;

import lombok.Data;

@Data
public class EditUser {
    private Long id;
    private String name;

    private Integer age;

    private Double salary;
}
