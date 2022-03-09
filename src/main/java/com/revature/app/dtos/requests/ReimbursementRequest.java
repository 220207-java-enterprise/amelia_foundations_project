package com.revature.app.dtos.requests;
import com.revature.app.models.Reimbursement;

import java.sql.Timestamp;

public class ReimbursementRequest extends Reimbursement {
    private String reimbId;
    private Float amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private String paymentId;
    private String authorId;
    private String resolverId;
    private String statusId;
    private String typeId;

    @Override
    public String getReimbId() {
        return reimbId;
    }

    @Override
    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }

    @Override
    public Float getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public Timestamp getSubmitted() {
        return submitted;
    }

    @Override
    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    @Override
    public Timestamp getResolved() {
        return resolved;
    }

    @Override
    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String getAuthorId() {
        return authorId;
    }

    @Override
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String getResolverId() {
        return resolverId;
    }

    @Override
    public void setResolverId(String resolverId) {
        this.resolverId = resolverId;
    }

    @Override
    public String getStatusId() {
        return statusId;
    }

    @Override
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @Override
    public String getTypeId() {
        return typeId;
    }

    @Override
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Reimbursement extractReimbursement() {
        return new Reimbursement(amount, description, authorId, typeId);
    }
}

