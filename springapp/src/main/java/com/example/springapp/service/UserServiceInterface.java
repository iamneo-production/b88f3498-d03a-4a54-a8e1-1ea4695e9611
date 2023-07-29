package com.example.springapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.model.LoginModel;

import com.example.springapp.model.User;

public interface UserServiceInterface {
    public List<User> getAllUsers();
    public ResponseEntity<User> createUser(User data);
    public User getUserById(long id);
    public void updateUserById(long id); //Response: user Updated
    ResponseEntity<String> deleteUserById(Long id) throws InvalidDeleteException;
    public ResponseEntity<User> loginByEmail(LoginModel loginData);
}
