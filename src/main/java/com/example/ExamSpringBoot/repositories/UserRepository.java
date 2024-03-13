package com.example.ExamSpringBoot.repositories;

import com.example.ExamSpringBoot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByNameContaining(String search);
}
