package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springapp.model.User;
import com.example.springapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // Retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Create a new user
    @PostMapping("/register")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "User Created";
    }

    // Retrieve a specific user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a specific user
    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") long id, @RequestBody User updatedUser) {
        updatedUser.setId(id);
        userService.updateUser(updatedUser);
        return "User Updated";
    }

    // Delete a specific user by ID
    @DeleteMapping("/id")
    public String deleteUserById(@RequestParam("id") long id) {
        userService.deleteUserById(id);
        return "User deleted";
    }
}
