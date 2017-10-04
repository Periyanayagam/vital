package com.example.saravanakumar8.vitalmed.Model.request;

/**
 * Created by perusu on 1/10/17.
 */

public class LoginRequest {

    String username, password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
