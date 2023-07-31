package com.example.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.springapp.config.SecurityConfig;

@SpringBootApplication
@ComponentScan
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{SpringappApplication.class, SecurityConfig.class}, args);
	}

	

}


