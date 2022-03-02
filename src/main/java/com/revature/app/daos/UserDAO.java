package com.revature.app.daos;

import com.revature.app.models.User;
import com.revature.app.models.UserRole;
import com.revature.app.util.ConnectionFactory;
import com.revature.app.util.exceptions.DataSourceException;
import com.revature.app.util.exceptions.ResourcePersistenceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// TODO attempt to centralize exception handling in service layer
public class UserDAO implements CrudDAO<User> {
    private List<User> user = new ArrayList<>();

    private final String rootSelect = "SELECT " +
            "au.user_id, au.username, au.email, au.PASSWORD, au.given_name, au.surname, au.is_active, ur.role_id " +
            "FROM users au " +
            "JOIN user_role ur " +
            "ON au.role = ur.role_id ";
    private User newUser;

    public UserDAO(User newUser) {
        this.newUser = newUser;
    }

    public User findUserByUsername(String username) {

        User user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setIsActive(rs.getBoolean("is_active"));
                user.setRoleId(rs.getString("role_id"));
                user.setRole(new UserRole(rs.getString("role"), rs.getString("role")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User findUserByEmail(String email) {

        User user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE email = ?");
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setIsActive(rs.getBoolean("is_active"));
                user.setRoleId(rs.getString("role_id"));
                user.setRole(new UserRole(rs.getString("role"), rs.getString("role")));

            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;

    }

    public User findUserByUsernameAndPassword(String username, String password) {

        User authUser = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE username = ? AND PASSWORD = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                authUser = new User();
                authUser.setUserId(rs.getString("user_id"));
                authUser.setUsername(rs.getString("username"));
                authUser.setEmail(rs.getString("email"));
                authUser.setPassword(rs.getString("PASSWORD"));
                authUser.setGivenName(rs.getString("given_name"));
                authUser.setSurname(rs.getString("surname"));
                authUser.setIsActive(rs.getBoolean("is_active"));
                authUser.setRoleId(rs.getString("role_id"));
                authUser.setRole(new UserRole(rs.getString("role"), rs.getString("role")));

            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return authUser;
    }

    @Override
    public void save(User newUsers) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, newUser.getUserId());
            pstmt.setString(2, newUser.getUsername());
            pstmt.setString(3, newUser.getEmail());
            pstmt.setString(4, newUser.getPassword());
            pstmt.setString(5, newUser.getGivenName());
            pstmt.setString(6, newUser.getSurname());
            pstmt.setBoolean(7, newUser.getIsActive());
            pstmt.setString(8, newUser.getSurname());
            pstmt.setString(9, newUser.getRoleId());
            pstmt.setString(10, newUser.getRole().getRoleId());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                conn.rollback();
                throw new ResourcePersistenceException("Failed to persist user to data source");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public User getByUserId(String userId) {

        User user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE user_id = ?");
            pstmt.setString(1, userId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setIsActive(rs.getBoolean("is_active"));
                user.setRoleId(rs.getString("role_id"));
                user.setRole(new UserRole(rs.getString("role"), rs.getString("role")));

            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;

    }

    @Override
    public List<User> getAll() {

        List<User> users = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            ResultSet rs = conn.createStatement().executeQuery(rootSelect);
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setIsActive(rs.getBoolean("is_active"));
                user.setRoleId(rs.getString("role_id"));
                user.setRole(new UserRole(rs.getString("role"), rs.getString("role")));
                users.add(user);                        //fix issue above
            }
        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return users;
    }

    @Override
    public void update(User updatedUser) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE user " +
                    "SET username = ?, " +
                    "email = ?, " +
                    "password = ?, " +
                    "givenName = ?, " +
                    "surname = ? " +
                    "is_active = ?, " +
                    "role_id = ? " +
                    "WHERE user_id = ?");
            pstmt.setString(1, updatedUser.getUserId());
            pstmt.setString(2, updatedUser.getUsername());
            pstmt.setString(3, updatedUser.getEmail());
            pstmt.setString(4, updatedUser.getPassword());
            pstmt.setString(5, updatedUser.getGivenName());
            pstmt.setString(6, updatedUser.getSurname());
            pstmt.setBoolean(7, updatedUser.getIsActive());
            pstmt.setString(8, updatedUser.getRoleId());

            // TODO allow role to be updated as well

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                throw new ResourcePersistenceException("Failed to update user data within datasource.");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public void deleteByUserId(String userId) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE user_id = ?");
            pstmt.setString(1, userId);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                conn.rollback();
                throw new ResourcePersistenceException("Failed to delete user from data source");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }
}