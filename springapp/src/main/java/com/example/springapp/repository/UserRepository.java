package com.example.springapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    void deleteById(Long id);

    Optional<User> findById(Long id);

    User findByEmail(String email);

}
