package com.revature.app.dtos.requests;

import com.revature.app.models.User;
import com.revature.app.models.UserRole;

import java.util.UUID;

public class NewUserRequest {

    private String givenName;
    private String surname;
    private String email;
    private String username;
    private String password;
    private String role;

    public NewUserRequest() {
        super();
    }

    public NewUserRequest (String givenName, String surname, String email, String username, String password, String role) {
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User extractUser() {
        String userId = UUID.randomUUID().toString();
        UserRole uRole = new UserRole(this.role, this.role);
        return new User(givenName, surname, email, username, password, uRole);
    }

    @Override
    public String toString() {
        return "NewUserRequest{" +
                "given_name='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}