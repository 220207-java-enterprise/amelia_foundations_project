package com.revature.app.dtos.responses;

import com.revature.app.models.Reimbursement;

import java.sql.Timestamp;

public class ReimbursementResponse extends Reimbursement {
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

    public ReimbursementResponse (Reimbursement reimbursement) {
        this.reimbId = reimbursement.getReimbId();
        this.amount = reimbursement.getAmount();
        this.submitted = reimbursement.getSubmitted();
        this.resolved = reimbursement.getResolved();
        this.description = reimbursement.getDescription();
        this.paymentId = reimbursement.getPaymentId();
        this.authorId = reimbursement.getAuthorId();
        this.resolverId = reimbursement.getResolverId();
        this.statusId = reimbursement.getStatusId();
        this.typeId = reimbursement.getTypeId();

    }

    public ReimbursementResponse(String newUser) {
        //return;
    }

    public String getReimbId() {
        return reimbId;
    }

    public Float getAmount() {
        return amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public String getDescription() {
        return description;
    }

    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public void Status(String statusId) {
        super.Status(statusId);
    }

    @Override
    public String toString() {
        return "ReimbursementResponse{" +
                "reimb_id='" + reimbId + '\'' +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", payment_id='" + paymentId + '\'' +
                ", resolver_id='" + resolverId + '\'' +
                ", status_id='" + statusId + '\'' +
                ", type_id='" + typeId + '\'' +
                '}';
    }
}