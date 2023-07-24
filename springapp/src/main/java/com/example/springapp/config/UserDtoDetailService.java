package com.example.springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.springapp.model.User;
import org.springframework.stereotype.Service;
import com.example.springapp.service.UserService;

@Service
public class UserDtoDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        
        if(user == null){
            throw new UsernameNotFoundException("User not found!!!");
            }
            return new UserDtoDetails(user);
        }
}