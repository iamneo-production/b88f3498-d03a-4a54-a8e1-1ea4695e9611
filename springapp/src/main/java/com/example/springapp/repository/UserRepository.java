package com.example.springapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.User;


public interface UserRepository extends CrudRepository<User, Long> {

}
