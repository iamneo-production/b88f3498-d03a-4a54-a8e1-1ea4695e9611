package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.UserNotFoundException;
import com.example.springapp.model.LoginModel;
import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public ResponseEntity<User> createUser(User user) throws UserNotFoundException{
        User dbUser = userRepository.findByEmail(user.getEmail());
        if(dbUser!=null){
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }

        String encrpytedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encrpytedPwd);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow();
    }

    public ResponseEntity<User> updateUser(User updatedUser) {
        userRepository.save(updatedUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK );
    }

   
   public ResponseEntity<String> deleteUserById(Long id) throws InvalidDeleteException{
    try {

        userRepository.deleteUserById(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
        } catch (Exception e) {
            
        throw new InvalidDeleteException("Error occurred while deleting the user.");
        }
    }

    public ResponseEntity<User> loginByEmail(LoginModel loginData){
        String email = loginData.getEmail();
        String password = loginData.getPassword();

        User user = userRepository.findByEmail(email);
        if (user == null || !passwordEncoder.matches(password,user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    } 
}
