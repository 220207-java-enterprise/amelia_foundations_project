package com.revature.app.daos;

import com.revature.app.dtos.responses.ReimbursementResponse;
import com.revature.app.models.Reimbursement;
import com.revature.app.models.User;
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

    private final String rootSelect = "FROM reimbursements " +
            "JOIN reimbursement_statuses " +
            "ON reimbursements.status_id=reimbursement_statuses.status_id " +
            "JOIN reimbursement_types " +
            "ON reimbursements.type_id=reimbursement_types.type_id ";

    public Reimbursement newReimbursement;

    public ReimbursementDAO() {
        this.newReimbursement = newReimbursement;
    }

    @Override
    public void save(Reimbursement newReimbursement) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO reimbursements VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, newReimbursement.getReimbId());
            pstmt.setFloat(2, newReimbursement.getAmount());
            pstmt.setTimestamp(3, newReimbursement.getSubmitted());
            pstmt.setTimestamp(4, newReimbursement.getResolved());
            pstmt.setString(5, newReimbursement.getDescription());
            pstmt.setString(6, newReimbursement.getPaymentId());
            pstmt.setString(7, newReimbursement.getAuthorId());
            pstmt.setString(8, newReimbursement.getResolverId());
            pstmt.setString(9, newReimbursement.getStatusId());
            pstmt.setString(10, newReimbursement.getTypeId());

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
    public Reimbursement getById(String id) {
        Reimbursement newReimbursement = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE reimb_id = ?");
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                newReimbursement = new Reimbursement();
                newReimbursement.setReimbId(rs.getString("reimb_id"));
                newReimbursement.setAmount(rs.getFloat("amount"));
                newReimbursement.setSubmitted(rs.getTimestamp("submitted"));
                newReimbursement.setResolved(rs.getTimestamp("resolved"));
                newReimbursement.setDescription(rs.getString("description"));
                //newReimbursement.setReceipt(rs.getByte("receipt"));
                newReimbursement.setPaymentId(rs.getString("payment_id"));
                newReimbursement.setAuthorId(rs.getString("author_id"));
                newReimbursement.setResolverId(rs.getString("resolver_id"));
                newReimbursement.setStatusObj(rs.getString("status_id"), rs.getString("status"));
                //newReimbursement.setTypeId(rs.getString("type_id"));
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
                newReimbursement.setAmount(rs.getFloat("amount"));
                newReimbursement.setSubmitted(rs.getTimestamp("submitted"));
                newReimbursement.setResolved(rs.getTimestamp("resolved"));
                newReimbursement.setDescription(rs.getString("description"));
                newReimbursement.setPaymentId(rs.getString("payment_id"));
                newReimbursement.setAuthorId(rs.getString("author_id"));
                newReimbursement.setResolverId(rs.getString("resolver_id"));
                newReimbursement.setStatusId(rs.getString("status_id"), rs.getString("status"));
                newReimbursement.setTypeId(rs.getString("type_id"));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return reimbursement;
    }

    @Override
    public void update(Reimbursement updatedReimbursement) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE reimbursements " +
                    "SET reimb_id = ?, " +
                    "amount = ?, " +
                    "submitted = ?, " +
                    "resolved = ?, " +
                    "description = ? " +
                    "payment_id = ? " +
                    "author_id = ? " +
                    "resolver_id = ?, " +
                    "status_id = ? " +
                    "type_id = ? " +
                    "WHERE user_id = ?");
            pstmt.setString(1, updatedReimbursement.getReimbId());
            pstmt.setFloat(2, (float) updatedReimbursement.getAmount());
            pstmt.setTimestamp(3, updatedReimbursement.getSubmitted());
            pstmt.setTimestamp(4, updatedReimbursement.getResolved());
            pstmt.setString(5, updatedReimbursement.getDescription());
            pstmt.setString(6, updatedReimbursement.getPaymentId());
            pstmt.setString(7, updatedReimbursement.getAuthorId());
            pstmt.setString(8, updatedReimbursement.getResolverId());
            pstmt.setString(9, updatedReimbursement.getStatusId());
            pstmt.setString(10, updatedReimbursement.getTypeId());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                throw new ResourcePersistenceException("Failed to update new reimbursement data within datasource.");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteById(User objectToDelete) {
    }


}

