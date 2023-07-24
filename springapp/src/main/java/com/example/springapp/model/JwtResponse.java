package com.example.springapp.model;

import java.util.List;

public class JwtResponse {

    String username;
    String token;
    /**
     * @param username
     * @param token
     * @param role
     */
    public JwtResponse(String username, String token, List<String> role) {
        this.username = username;
        this.token = token;
        this.role = role;
    }
    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }
    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
    List<String> role;
      
}
