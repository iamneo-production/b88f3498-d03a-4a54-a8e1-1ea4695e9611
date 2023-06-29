package com.example.springapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    void deleteById(int id);

    Optional<User> findById(int id);

    User findByEmail(String email);

}
