package com.revature.app.dtos.responses;

import com.revature.app.models.User;

public class UserResponse {

    private String userId;
    private String username;
    private String givenName;
    private String surname;
    private String role;


    public UserResponse(String userId) {
        super();
    }

    public UserResponse(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.givenName = user.getGivenName();
        this.surname = user.getSurname();
        this.role = user.getRole().getRoleName();

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}