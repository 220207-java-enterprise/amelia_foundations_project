package com.revature.app.services;

import com.revature.app.dtos.requests.LoginRequest;
import com.revature.app.dtos.responses.UserResponse;
import com.revature.app.models.User;
import com.revature.app.daos.CrudDAO;
/*import com.revature.app.models.UserRole;
import com.revature.app.util.exceptions.AuthenticationException;
import com.revature.app.util.exceptions.InvalidRequestException;
import com.revature.app.util.exceptions.ResourceConflictException;*/

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


//TODO implement Spring security for user role
public class UserRoleService {

    private CrudDAO<User> userRoleDAO;

    public UserRoleService(CrudDAO<User> userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }

    public List<UserResponse> getAllUser() {

        // Java 8+ mapping logic (with Streams)
        return userRoleDAO.getAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }
}

    /*public UserRole register(NewUserRoleRequest newUserRoleRequest) {

        UserRole newUserRole = newUserRoleRequest.extractUserRole();

        if (!isUserRoleValid(newUserRole)) {
            throw new InvalidRequestException("Invalid user role requested.");
        }

        boolean UserRoleAvailable = isUserRoleAvailable(newUserRole.getUserRole());
        //boolean idAvailable = isIdAvailable(newUserRole.getId());

        if (!UserRoleAvailable || !UserRoleAvailable) {
            String msg = "The values provided for the following fields are already taken by other users: ";
            if (!UserRoleAvailable) msg += "role_id ";
            if (!UserRoleAvailable) msg += "role";
            throw new ResourceConflictException(msg);
        }

        // TODO encrypt provided password before storing in the database

        newUserRole.setRoleId(UUID.randomUUID().toString());
        newUserRole.setRole(String.valueOf(new UserRole("7c3521f5-ff75-4e8a-9913-01d15ee4dc97", "BASIC_USER"))); // All newly registered users start as BASIC_USER
        userRoleDAO.save(newUserRole);

        return newUserRole;
    }

    *//*public UserRole login(LoginRequest loginRequest) {

        String roleId = loginRequest.getRoleId();
        String role = loginRequest.getRole();

        if (isRoleIdValid(roleId) || !isRoleValid(role)) {
            throw new InvalidRequestException("Invalid credentials provided!");
        }*//*
    // TODO encrypt provided roleId (assumes roleId encryption is in place) to see if it matches what is in the DB

    *//*UserRole authUser = userRoleDAO.findUserRoleByRoleIdAndRole(roleId, role);

        if (authUser == null) {
            throw new AuthenticationException();
        }

        return authUser;

    }
*//*
    private boolean isRoleValid(UserRole role) {

         //RoleId must be unique and match role
        if (isRoleIdValid(roleId.getRoleId())) {
            return true;*//*

        // Users must choose from the specified roles
        if (isRoleValid(Role.getRole())) {
            return true;
        }
        return true;
    }
}*/
