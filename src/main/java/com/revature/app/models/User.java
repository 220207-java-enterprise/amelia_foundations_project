package com.revature.app.models;
//import java superclass Objects
import java.util.Objects;

// create User class and encapsulating User states
public class User {

    private String userId;
    private String givenName;
    private String surname;
    private String email;
    private String username;
    private String password;
    private Boolean isActive;
    private UserRole role;

    public User() {
        super();
    }
    //creating constructor for parameters
    public User(String userId, String givenName, String surname, String email, String username, String password, UserRole role) {
        this.userId = userId;
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
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
        User users = (User) o;
        return Objects.equals(userId, users.userId)
                && Objects.equals(username, users.username)
                && Objects.equals(email, users.email)
                && Objects.equals(password, users.password)
                && Objects.equals(givenName, users.givenName)
                && Objects.equals(surname, users.surname)
                && Objects.equals(isActive, users.isActive)
                && Objects.equals(role, users.role);
    }
    //overriding hashCode method so we get proper values
    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, givenName, surname, isActive, role);
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
                ", role='" + role + '\'' +
                '}';
    }

}