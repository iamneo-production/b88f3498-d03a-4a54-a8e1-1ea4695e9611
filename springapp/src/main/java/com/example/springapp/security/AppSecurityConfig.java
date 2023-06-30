package com.example.springapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// @EnableWebSecurity
// public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private CustomUserDetailsService userDetailsService;

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//                 .authorizeRequests()
//                 .antMatchers("/user/register").permitAll()
//                 .antMatchers("/user/**").permitAll()
//                 .and().httpBasic();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }

@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/user/**").permitAll()
                // .antMatchers("/user/register").hasRole("ADMIN")
                // .antMatchers("/user/**").authenticated()
                .and().httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder pEncoder() {
        return new BCryptPasswordEncoder();
    }
}
