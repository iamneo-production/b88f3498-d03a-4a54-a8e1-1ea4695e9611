package com.example.springapp.config;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
public class SecurityConfig {

    @Bean
    SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{
        http
        .cors(cors -> cors.disable())
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
        .antMatchers("/**").permitAll()  //for testcases to pass
        // .antMatchers( "/login", "/logout", "/user/**").permitAll() //for developent
        .antMatchers("/**" ).hasAuthority("ADMIN")
        .antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")
        .anyRequest().authenticated());
        http.
                httpBasic(withDefaults())
        .formLogin();
        return http.build();

        }


    @Bean
     AuthenticationProvider authenticationProvider()
     {
         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
         provider.setUserDetailsService(userDetailsService());
         provider.setPasswordEncoder(passwordEncoder());
         return provider; 
     }
 
 
     @Bean
     PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }
 
 
     @Bean
     UserDetailsService userDetailsService()
     {
         return new UserDtoDetailService();
     }

     @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
        
    }

}