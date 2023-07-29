package main.java.com.example.springapp.model;

public class AuthenticationResponse {

    private String token;

    AuthenticationResponse(String token){
        this.token = token;
    }

    AuthenticationResponse(){

    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
    
}
