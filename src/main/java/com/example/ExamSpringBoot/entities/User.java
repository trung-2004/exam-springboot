package com.example.ExamSpringBoot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age can not be less than 18")
    @Max(value = 50, message = "Age can not be greater than 50")
    private Integer age;

    @Column(nullable = false)
    @NotNull(message = "Salary cannot be null")
    @Min(value = 0, message = "Salary must be greater than or equal to 0")
    private Double salary;
}
