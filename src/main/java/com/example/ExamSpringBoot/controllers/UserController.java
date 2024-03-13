package com.example.ExamSpringBoot.controllers;

import com.example.ExamSpringBoot.dtos.ResponseObject;
import com.example.ExamSpringBoot.dtos.UserDTO;
import com.example.ExamSpringBoot.entities.User;
import com.example.ExamSpringBoot.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAll(){
        Iterable<UserDTO> list = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("true", "ok", list)
        );
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> insertUser(@Valid @RequestBody User model){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("true", "ok", userService.save(model))
        );
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User model) {
        Optional<User> userOptional = userService.findById(id);
        return userOptional.map(user1 -> {
            model.setId(user1.getId());
            return new ResponseEntity<>(userService.save(model), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteCategory(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        return userOptional.map(category -> {
            userService.remove(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public List<User> search(String search){
        return userService.searchUser(search);
    }



}
