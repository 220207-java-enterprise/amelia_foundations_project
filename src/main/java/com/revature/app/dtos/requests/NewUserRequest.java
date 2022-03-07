package com.revature.app.dtos.requests;

import com.revature.app.models.User;
import com.revature.app.models.UserRole;

import java.util.UUID;

public class NewUserRequest extends User {

    private String userId;
    private String givenName;
    private String surname;
    private String email;
    private String username;
    private String password;
    private UserRole role;

    public NewUserRequest() {
        super();
    }

    public NewUserRequest (String userId, String givenName, String surname, String email, String username, String password, UserRole role) {
        this.userId = userId;
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public User extractUser() {
        String userId = UUID.randomUUID().toString();
        UserRole uRole = new UserRole();
        return new User(userId, givenName, surname, email, username, password, uRole);
    }

    @Override
    public String toString() {
        return "NewUserRequest{" +
                "user_id='" + userId + '\'' +
                "given_name='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}