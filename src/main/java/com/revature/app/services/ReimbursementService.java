package com.revature.app.services;

import com.revature.app.daos.ReimbursementDAO;
import com.revature.app.models.Reimbursement;
import com.revature.app.models.ReimbursementStatuses;
import com.revature.app.dtos.requests.ReimbursementRequest;
import com.revature.app.dtos.requests.UpdateReimbursementRequest;
import com.revature.app.util.exceptions.InvalidRequestException;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReimbursementService {
    final private ReimbursementDAO reimbursementDAO;

    public ReimbursementService(ReimbursementDAO reimbursementDAO) {
        this.reimbursementDAO = reimbursementDAO;
    }

    public Reimbursement createReimbursementRequest(ReimbursementRequest reimbursementRequest) throws IOException {
        Reimbursement newReimbursement = reimbursementRequest.extractReimbursement();

        ReimbursementStatuses reimbursementStatuses = new ReimbursementStatuses("1", "pending");
        //newReimbursement.setReimbId(UUID.randomUUID().toString());
        //newReimbursement.setStatusId(reimbursementStatuses);
        reimbursementDAO.save(newReimbursement);

        return newReimbursement;
    }

    public Reimbursement updateReimbursementStatus(UpdateReimbursementRequest updateReimbursementRequest) {
        Reimbursement originalReimbursement = reimbursementDAO.getById(updateReimbursementRequest.getReimbId());
        ReimbursementStatuses newReimbursementStatus = new ReimbursementStatuses(updateReimbursementRequest.getStatus(), updateReimbursementRequest.getStatus());

        //Updating the status
        originalReimbursement.setStatus(newReimbursementStatus);

        //adding resolved timestamp
        Timestamp resolvedTimeStamp = new Timestamp(System.currentTimeMillis());
        originalReimbursement.setResolved(resolvedTimeStamp);

        //adding resolver id
        originalReimbursement.setResolverId(updateReimbursementRequest.getResolverId());

        //saving reimbursement with new status
        reimbursementDAO.update(originalReimbursement);

        return reimbursementDAO.getById(updateReimbursementRequest.getReimbId());
    }

    public List<Reimbursement> getAll() {

        return reimbursementDAO.getAll()
                .stream()
                //.map(Reimbursement::new)
                .collect(Collectors.toList());
    }
}

