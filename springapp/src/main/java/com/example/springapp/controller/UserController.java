package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.User;
import com.example.springapp.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<String>("User Created", HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<User> getAllUsers(){
        return userService.findAllUsers();
    }
}
