package com.revature.app.services;

import com.revature.app.dtos.requests.LoginRequest;
import com.revature.app.dtos.requests.NewUserRequest;
import com.revature.app.dtos.responses.UserResponse;
import com.revature.app.models.User;
import com.revature.app.daos.UserDAO;
import com.revature.app.daos.CrudDAO;
import com.revature.app.models.UserRole;
import com.revature.app.util.exceptions.AuthenticationException;
import com.revature.app.util.exceptions.InvalidRequestException;
import com.revature.app.util.exceptions.ResourceConflictException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService {

    public UserDAO userDAO; // a dependency of UserService

    // Constructor injection
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserResponse> getAllUsers() {

        // Java 8+ mapping logic (with Streams)
        return userDAO.getAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public User register(NewUserRequest newUserRequest) {

        User newUser = newUserRequest.extractUser();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + newUser);

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Bad registration details given.");
        }

        boolean usernameAvailable = isUsernameAvailable(newUser.getUsername());
        boolean emailAvailable = isEmailAvailable(newUser.getEmail());

        if (!usernameAvailable || !emailAvailable) {
            String msg = "The values provided for the following fields are already taken by other users: ";
            if (!usernameAvailable) msg += "username ";
            if (!emailAvailable) msg += "email";
            throw new ResourceConflictException(msg);
        }

        // TODO encrypt provided password before storing in the database

        newUser.setUserId(UUID.randomUUID().toString());
        newUser.setRole(new UserRole("003", "EMPLOYEE")); // All newly registered users start as BASIC_USER
        userDAO.save(newUser);

        return newUser;
    }

    public User login(LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (!isUsernameValid(username) || !isPasswordValid(password)) {
            throw new InvalidRequestException("Invalid credentials provided!");
        }

        // TODO encrypt provided password (assumes password encryption is in place) to see if it matches what is in the DB
        User authUser = userDAO.findUserByUsernameAndPassword(username, password);

        if (authUser == null) {
            throw new AuthenticationException();
        }

        return authUser;

    }

    boolean isUserValid(User users) {

        if (users == null) {
            return false;
        }

        // First name and last name are not just empty strings or filled with whitespace
        if (users.getGivenName().trim().equals("") || users.getSurname().trim().equals("")) {
            return false;
        }

        // Usernames must be a minimum of 8 and a max of 25 characters in length, and only contain alphanumeric characters.
        if (!isUsernameValid(users.getUsername())) {
            return false;
        }

        // Passwords require a minimum eight characters, at least one uppercase letter, one lowercase
        // letter, one number and one special character
        if (!isPasswordValid(users.getPassword())) {
            return false;
        }

        // Basic email validation
        return isEmailValid(users.getEmail());

    }

    public boolean isEmailValid(String email) {
        if (email == null) return false;
        return email.matches("^[^@\\s]+@[^@\\s.]+\\.[^@.\\s]+$");
    }

    public boolean isUsernameValid(String username) {
        if (username == null) return false;
        return username.matches("^[a-zA-Z0-9]{8,25}");
    }

    public boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    public boolean isUsernameAvailable(String username) {
        if (username == null || !isUsernameValid(username)) return false;
        return userDAO.findUserByUsername(username) == null;
    }

    public boolean isEmailAvailable(String email) {
        if (email == null || !isEmailValid(email)) return false;
        return userDAO.findUserByEmail(email) == null;
    }

}