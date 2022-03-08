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
    private final Author author = new Author();
    private final Resolver resolver = new Resolver();
    private Status status;
    private Type type;

    public Reimbursement() {
        super();
    }

    public Reimbursement(
            Float amount,
            String description,
            String typeId
    ) {
        this.amount = amount;
        this.description = description;
        this.type = new Type(typeId);
   //">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        // generate id
        /*this.reimbId = UUID.randomUUID().toString();
        // set status to approved
        this.status = new Status("pending");*/
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
        return this.author.userId;
    }
    public void setAuthorId(String userId) {
        this.author.userId = userId;
    }

    public String getAuthor() {
        return this.author.username;
    }
    public void setAuthor (String username) {
        this.author.username = username;
    }

    public String getResolverId() {
        return this.resolver.userId;
    }
    public void setResolverId(String userId) {
        this.resolver.userId = userId;
    }

    public String getResolver() {
        return this.resolver.username;
    }
    public void setResolver(String username) {
        this.resolver.username = username;
    }

    public String getStatusId() {    PROBLEM
        return this.status.statusId;
    }
    public String getStatus() {
        return this.status.status;
    }
    public void setStatusObj(String statusId, String status) {
        this.status = new Status(statusId);
    }

    public String getTypeId() {
        return this.type.typeId;
    }
    public String getType() {
        return this.type.type;
    }
    public void setTypeObj(String typeId) {
        this.type = new Type(typeId);
    }

    private static class Author {
        private String userId;
        private String username;
    }

    private static class Resolver {
        private String userId;
        private String username;
    }

    private static class Status {   PROBLEM
        private final String statusId;
        private final String status;

        private Status(String statusId) {
            this.statusId = statusId;

            switch (statusId) {
                case "01":
                    this.status = "pending";
                    break;
                case "02":
                    this.status = "approved";
                    break;
                case "03":
                    this.status = "denied";
                    break;
                default:
                    throw new InvalidRequestException("StatusId \"" + statusId + "\" is not valid.");
            }
        }
    }

    private static class Type {
        private final String typeId;
        private final String type;

        private Type(String typeId) {
            this.typeId = typeId;

            switch (typeId) {
                case "T":
                    this.type = "Travel";
                    break;
                case "L":
                    this.type = "Lodging";
                    break;
                case "F":
                    this.type = "Food";
                    break;
                case "O":
                    this.type = "Other";
                    break;
                default:
                    throw new InvalidRequestException("TypeId \"" + typeId + "\" is not valid.");
            }
        }
    }
}