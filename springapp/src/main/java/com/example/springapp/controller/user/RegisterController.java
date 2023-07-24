package com.example.springapp.controller.user;

import javax.validation.Valid;

import com.example.springapp.model.User;
import com.example.springapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
    
}
