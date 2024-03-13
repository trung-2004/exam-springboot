package com.example.ExamSpringBoot.services;

import com.example.ExamSpringBoot.dtos.UserDTO;
import com.example.ExamSpringBoot.entities.User;
import com.example.ExamSpringBoot.model.CreateUser;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Iterable<UserDTO> findAll();

    Optional<User> findById(Long id);

    User save(User t);

    void remove(Long id);

    List<User> searchUser(String search);
}
