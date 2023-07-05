package com.example.springapp.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public ResponseEntity<User> createUser(User user) {
        User dbUser = userRepository.findByEmail(user.getEmail());
        if(dbUser!=null){
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("message", "User Already Exists!!!");
            
            return new ResponseEntity<User>(map, HttpStatus.ALREADY_REPORTED);
        }

        String encrpytedPwd = bcrypt.encode(user.getPassword());
        user.setPassword(encrpytedPwd);
        userRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow();
    }

    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public ResponseEntity<User> loginByEmail(Map<String, String> loginData){
        String email = loginData.get("email");
        String password = loginData.get("password");

        User user = userRepository.findByEmail(email);
        if (user == null || !bcrypt.matches(password,user.getPassword())) {
            return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
        }


        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
