package com.revature.app.dtos.requests;

import com.revature.app.models.User;
import com.revature.app.models.UserRole;

public class NewUserRequest {

    private String givenName;
    private String surname;
    private String email;
    private String username;
    private String password;
    private Boolean isActive;
    private String roleId;
    private UserRole role;

    public NewUserRequest() {
        super();
    }

    public NewUserRequest(String givenName, String surname, String email, String username, String password, Boolean isActive, String roleId, UserRole role) {
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.roleId = roleId;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public User extractUser() {
        return new User(givenName, surname, email, username, password, isActive, roleId, role);
    }

    @Override
    public String toString() {
        return "NewUserRequest{" +
                "given_name='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", is_active='" + isActive + '\'' +
                ", role_id='" + roleId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}