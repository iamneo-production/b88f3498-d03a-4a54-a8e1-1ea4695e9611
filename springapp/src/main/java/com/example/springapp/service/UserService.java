package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

}
