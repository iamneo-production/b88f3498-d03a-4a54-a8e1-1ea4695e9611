package com.example.springapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface UserRepository extends CrudRepository<User, Integer> {

    void deleteById(long id);

    Optional<User> findById(long id);

    User findByEmail(String email);

}
