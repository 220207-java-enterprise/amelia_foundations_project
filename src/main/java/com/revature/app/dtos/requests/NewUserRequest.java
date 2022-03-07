package com.revature.app.dtos.requests;

import com.revature.app.models.User;

public class NewUserRequest {

    private String givenName;
    private String surname;
    private String email;
    private String username;
    private String password;

    public NewUserRequest() {
        super();
    }

    public NewUserRequest (String givenName, String surname, String email, String username, String password) {
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /*public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }*/

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

    /*public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }*/

    public User extractUser() {
        return new User(givenName, surname, email, username, password);
    }

    @Override
    public String toString() {
        return "NewUserRequest{" +
                //"user_id='" + userId + '\'' +
                "given_name='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                //", role='" + role + '\'' +
                '}';
    }
}