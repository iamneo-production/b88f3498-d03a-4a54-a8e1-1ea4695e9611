package com.example.springapp.admin;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;

@RestController
@Transactional
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/status/{email}/{changeStatusTo}")
    public ResponseEntity<?> changeStatus(@PathVariable("email") String email,
            @PathVariable("changeStatusTo") boolean status) {
        User user = userRepository.findByEmail(email);
        user.setEnabled(status);
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email) {
        userRepository.deleteByEmail(email);
        return new ResponseEntity<String>(email, HttpStatus.OK);
    }

    @PutMapping("/changeRole/{email}/{changeRoleTo}")
    public ResponseEntity<String> changeRole(@PathVariable("email") String email,
            @PathVariable("changeRoleTo") String role) {
        User user = userRepository.findByEmail(email);
        user.setRole(role);
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
