package com.example.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
     
    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{
        http
        .csrf().disable()
        .authorizeRequests()
        // .antMatchers("/user/register").hasRole("ADMIN")
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated();

        return http.build();
        
        
    }
}
