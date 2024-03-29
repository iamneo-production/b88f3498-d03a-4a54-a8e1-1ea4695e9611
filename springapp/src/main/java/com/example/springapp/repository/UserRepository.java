package com.example.springapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {

    void deleteUserById(long id);

    Optional<User> findById(long id);

    User findByEmail(String email);

    void deleteByEmail(String email);

}
