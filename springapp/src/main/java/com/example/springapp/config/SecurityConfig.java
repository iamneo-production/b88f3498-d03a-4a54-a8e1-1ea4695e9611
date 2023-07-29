package com.example.springapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.springapp.filters.JwtRequestFilter;
import javax.annotation.PostConstruct;
import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Autowired 
    private UserRepository userRepository;

    @Bean
    SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        return 

        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/login", "/register")
                // allow all paths to pass testcases
                // .antMatchers("/**")
                .permitAll()
                .antMatchers("/user/**", "/workout/**", "/api/**", "/sets/**", "/goal/**", "/nutrition/**", "/users/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(this.authenticationProvider())
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDtoDetailService();
    }


    private static final Long MAX_AGE = 3600L;
    private static final int CORS_FILTER_ORDER = -102;

    @Bean

    FilterRegistrationBean<?> corsFilter() {  //to register a filter
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  //to register CorsConfiguration
        CorsConfiguration config = new CorsConfiguration();  //to create configuration
        config.setAllowCredentials(true); //to configure whether cors req. should contain Authorization header or not 
        config.addAllowedOrigin("https://8081-fcdeefeecdaaaccdcddcffebdffccbebc.project.examly.io");
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT));
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name(),
                "OPTIONS",
                "PATCH"
                ));
        config.setMaxAge(MAX_AGE); //request's response stored in cache for faster access
        source.registerCorsConfiguration("/**", config); //to register cors at at specific path
        FilterRegistrationBean<?> bean = new FilterRegistrationBean<>(new CorsFilter(source)); //to register CorsFilter
        bean.setOrder(CORS_FILTER_ORDER); //order of filter execution
        return bean;
    }

    @PostConstruct
    public void createDefaultAdmin() {
        User admin = new User();
        admin.setName("admin");
        admin.setAge(23);
        admin.setWeight("23kg");
        admin.setGender("Female");
        admin.setHeight("166cm");
        admin.setEnabled(true);
        admin.setGoals("Maintain Security");
        admin.setEmail("admin@fitness.com");
        admin.setPassword( passwordEncoder().encode("Admin@121"));
        admin.setRole("ADMIN");
        if(userRepository.findByEmail("admin@fitness.com")==null){
            userRepository.save(admin);
        }
    }
}