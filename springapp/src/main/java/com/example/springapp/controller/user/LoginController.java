package com.example.springapp.controller.user;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import com.example.springapp.model.JwtResponse;
import com.example.springapp.model.LoginModel;
import com.example.springapp.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    // @Autowired
    // private UserDtoDetailService userDtoDetailService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginModel loginModel,
            HttpServletResponse response)
            throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        if (authentication.isAuthenticated()) {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<String> roles = principal.getAuthorities().stream().map(authorities -> authorities.getAuthority())
                    .collect(Collectors.toList());
            // ResponseCookie generatedCookie = jwtUtil.generateCookie(principal);
            String token = jwtUtil.generateToken(principal.getUsername());
            return ResponseEntity
                    .ok()
                    // .header("token", token)
                    .body(new JwtResponse(principal.getUsername(), token, roles));
        } else {
            throw new UsernameNotFoundException("Invalid User Credentials");
        }

    }
}
