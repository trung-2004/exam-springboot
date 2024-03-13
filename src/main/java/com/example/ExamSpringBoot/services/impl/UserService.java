package com.example.ExamSpringBoot.services.impl;

import com.example.ExamSpringBoot.dtos.UserDTO;
import com.example.ExamSpringBoot.entities.User;
import com.example.ExamSpringBoot.model.CreateUser;
import com.example.ExamSpringBoot.repositories.UserRepository;
import com.example.ExamSpringBoot.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<UserDTO> findAll() {
        List<User> list = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        for (User user : list) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setAge(user.getAge());
            userDTO.setSalary(user.getSalary());
            dtoList.add(userDTO);
        }
        return dtoList;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User t) {
        return userRepository.save(t);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> searchUser(String search){
        return userRepository.findAllByNameContaining(search);
    }
}
