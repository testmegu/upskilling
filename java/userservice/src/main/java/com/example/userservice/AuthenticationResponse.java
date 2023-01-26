package com.example.userservice;

public class AuthenticationResponse {

    private String username;
    private String response;
    private String jwt;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResponse() {
        return response;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse(String username, String response, String jwt, String role) {
        this.username = username;
        this.response = response;
        this.jwt = jwt;
        this.role = role;
    }

    public AuthenticationResponse() {
    }

}
