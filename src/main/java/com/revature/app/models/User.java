package com.revature.app.models;
//import java superclass Objects
import java.util.Objects;

// create User class and encapsulating User states
public class User {

    private String userId;
    private String username;
    private String email;
    private String password;
    private String givenName;
    private String surname;
    private Boolean isActive;
    private String roleId;
    private UserRole role;

    public User() {
        super();
    }
    //creating constructor for parameters
    public User(String userId, String username, String email, String password, String givenName, Boolean isActive, String roleId, UserRole role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.givenName = givenName;
        this.surname = surname;
        this.isActive = isActive;
        this.roleId = roleId;
        this.role = role;
    }
    //getters and setters for encapsulated data
   public String getUserId() {
        return this.userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    //overriding the equals method to compare data
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId)
                && Objects.equals(username, user.username)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(givenName, user.givenName)
                && Objects.equals(surname, user.surname)
                && Objects.equals(isActive, user.isActive)
                && Objects.equals(roleId, user.roleId)
                && Objects.equals(role, user.role);
    }
    //overriding hashCode method so we get proper values
    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, givenName, surname, isActive, roleId ,role);
    }
    //overriding toString method for client/user readability
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", isActive='" + isActive + '\'' +
                ", role_id='" + roleId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}