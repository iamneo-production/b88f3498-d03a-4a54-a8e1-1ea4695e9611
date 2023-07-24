package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.UserNotFoundException;
import com.example.springapp.model.User;
import com.example.springapp.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/user")
@CrossOrigin( origins="https://8081-cedbefdfddfcebbdaaaccdcddcffebdffccbebc.project.examly.io", maxAge = 3600, allowCredentials="true")
public class UserController {

    @Autowired
    private UserService userService;

    // Retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Retrieve a specific user by ID
    @GetMapping("/id")
    public ResponseEntity<User> getUserById(@RequestParam("id") long id) throws UserNotFoundException{
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    


    // Update a specific user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User updatedUser) {
        updatedUser.setId(id);
        return userService.updateUser(updatedUser);
        
    }

    // Delete a specific user by ID
    @DeleteMapping("/id")
    public String deleteUserById(@RequestParam("id") long id) throws InvalidDeleteException {
        userService.deleteUserById(id);
        return "User deleted";
    }

@GetMapping("/getCurrentUser")
public User getCurrentUser() {
    return userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
}

@GetMapping("/isAuthenticated")
public boolean isAuthenticated() {
    boolean authentication = false;
    if (SecurityContextHolder.getContext().getAuthentication().getName() != "anonymousUser") {
        authentication = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }
    return authentication;
}
}