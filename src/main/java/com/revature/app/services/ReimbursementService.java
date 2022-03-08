package com.revature.app.services;

import com.revature.app.daos.ReimbursementDAO;
import com.revature.app.daos.UserDAO;
import com.revature.app.dtos.responses.Principal;
import com.revature.app.dtos.responses.ReimbursementResponse;
import com.revature.app.models.Reimbursement;
import com.revature.app.dtos.requests.ReimbursementRequest;
import com.revature.app.util.exceptions.InvalidRequestException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ReimbursementService {
    final private ReimbursementDAO reimbursementDAO;
    final private UserDAO userDAO;

    public ReimbursementService(ReimbursementDAO reimbursementDAO, UserDAO userDAO) {
        this.reimbursementDAO = reimbursementDAO;
        this.userDAO = userDAO;
    }

    public void request(Reimbursement reimbursement, ReimbursementRequest request) {
        Reimbursement newReimbursement = request.extractReimbursement();
        newReimbursement.setAuthorId(reimbursement.getAuthorId());

        reimbursementDAO.save(newReimbursement);   //PROBLEM
    }

    public List<ReimbursementResponse> getAll() {
        return reimbursementDAO.getAll()
                .stream()
                .map(ReimbursementResponse::new)
                .collect(Collectors.toList());
    }

    }


