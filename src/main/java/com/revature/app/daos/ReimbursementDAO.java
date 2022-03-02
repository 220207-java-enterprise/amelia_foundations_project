package com.revature.app.daos;

import com.revature.app.models.Reimbursement;
import com.revature.app.models.User;
import com.revature.app.models.UserRole;
import com.revature.app.util.ConnectionFactory;
import com.revature.app.util.exceptions.DataSourceException;
import com.revature.app.util.exceptions.ResourcePersistenceException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO implements CrudDAO<Reimbursement> {

    private List<Reimbursement> reimbursement = new ArrayList<>();

    private final String rootSelect = "SELECT " +
            "au.reimb_id, au.amount, au.submitted, au.resolved, au.description, au.receipt, au.payment_id, ur.author_id, au.resolver_id, au.status_id, ur.type_id " +
            "FROM reimbursements au " +
            "JOIN reimbursement_types ur " +   ///fix statement!!
            "ON au.type = ur.type_id ";
    private Reimbursement newReimbursement;

    public ReimbursementDAO(Reimbursement newReimbursement) {
        this.newReimbursement = newReimbursement;
    }

    @Override
    public void save(Reimbursement newReimbursement) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO reimbursement_types VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?)");
            pstmt.setString(1, newReimbursement.getReimbId());
            pstmt.setInt(2, newReimbursement.getAmount());
            pstmt.setTimestamp(3, newReimbursement.getSubmitted());
            pstmt.setTimestamp(4, newReimbursement.getResolved());
            pstmt.setString(5, newReimbursement.getDescription());
            pstmt.setByte(6, newReimbursement.getReceipt());
            pstmt.setString(7, newReimbursement.getPaymentId());
            pstmt.setString(8, newReimbursement.getAuthorId());
            pstmt.setString(9, newReimbursement.getResolverId());
            pstmt.setString(10, newReimbursement.getStatusId());
            pstmt.setString(11, newReimbursement.getTypeId());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                conn.rollback();
                throw new ResourcePersistenceException("Failed to persist reimbursement to data source");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public Reimbursement getByUserId(String userId) {
        Reimbursement aReimbursement = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE reimb_id = ?");
            pstmt.setString(1, userId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                newReimbursement = new Reimbursement();
                newReimbursement.setReimbId(rs.getString("reimb_id"));
                newReimbursement.setAmount(rs.getInt("amount"));
                newReimbursement.setSubmitted(rs.getTimestamp("submitted"));
                newReimbursement.setResolved(rs.getTimestamp("resolved"));
                newReimbursement.setDescription(rs.getString("description"));
                newReimbursement.setReceipt(rs.getByte("receipt"));
                newReimbursement.setPaymentId(rs.getString("payment_id"));
                newReimbursement.setAuthorId(rs.getString("author_id"));
                newReimbursement.setResolverId(rs.getString("resolver_id"));
                newReimbursement.setStatus(rs.getString("status_id"), rs.getString("status"));
                newReimbursement.setType(rs.getString("type_id"), rs.getString("type"));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return newReimbursement;
    }

    @Override
    public List<Reimbursement> getAll() {

        List<Reimbursement> reimbursement = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            ResultSet rs = conn.createStatement().executeQuery(rootSelect);
            while (rs.next()) {
                newReimbursement = new Reimbursement();
                newReimbursement.setReimbId(rs.getString("reimb_id"));
                newReimbursement.setAmount(rs.getInt("amount"));
                newReimbursement.setSubmitted(rs.getTimestamp("submitted"));
                newReimbursement.setResolved(rs.getTimestamp("resolved"));
                newReimbursement.setDescription(rs.getString("description"));
                newReimbursement.setReceipt(rs.getByte("receipt"));
                newReimbursement.setPaymentId(rs.getString("payment_id"));
                newReimbursement.setAuthorId(rs.getString("author_id"));
                newReimbursement.setResolverId(rs.getString("resolver_id"));
                newReimbursement.setStatus(rs.getString("status_id"), rs.getString("status"));
                newReimbursement.setType(rs.getString("type_id"), rs.getString("type"));                 //fix issue above
            }
        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return reimbursement;
    }

    @Override
    public void update(Reimbursement updatedObject) {

    }
//soft delete
    @Override
    public void deleteByUserId(String userId) {

    }

    @Override
    public Reimbursement findUserByUsername(String username) {
        return null;
    }

}

