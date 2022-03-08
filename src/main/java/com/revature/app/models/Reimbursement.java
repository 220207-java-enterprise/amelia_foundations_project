package com.revature.app.models;
import com.revature.app.util.exceptions.InvalidRequestException;

import java.sql.Timestamp;

public class Reimbursement {
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

    public Reimbursement() {
        super();
    }

    public Reimbursement(Float amount, String description, String authorId, String typeId) {
        this.amount = amount;
        this.description = description;
        this.authorId = authorId;
        this.typeId = typeId;
    }

    public String getReimbId() {
        return this.reimbId;
    }
    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }

    public Float getAmount() {
        return this.amount;
    }
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return this.submitted;
    }
    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return this.resolved;
    }
    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentId() {
        return this.paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAuthorId() {
        return this.authorId;
    }
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getResolverId() {
        return this.resolverId;
    }
    public void setResolverId(String resolverId) {
        this.resolverId = resolverId;
    }


    public String getStatusId() {
        System.out.println(this.statusId + "right here");
        return this.statusId = statusId;   //PROBLEM
    }

    public void setStatusObj(String statusId, String status) {
        this.statusId = statusId;
        System.out.println(this.statusId + "this is it");
    }

    public String getTypeId() {
        return this.typeId;
    }

    public void setStatusId(String statusId, String status) {
        this.statusId = statusId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    private void StatusId(String statusId) {
            this.statusId = statusId;

            switch (statusId) {
                case "01":
                    this.statusId = "pending";
                    break;
                case "02":
                    this.statusId = "approved";
                    break;
                case "03":
                    this.statusId = "denied";
                    break;
                default:
                    throw new InvalidRequestException("StatusId \"" + statusId + "\" is not valid.");
            }
        }
}