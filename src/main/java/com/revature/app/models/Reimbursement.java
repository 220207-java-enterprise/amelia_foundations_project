package com.revature.app.models;
//import java SQL timestamp and superclass Objects
import java.sql.Timestamp;
import java.util.Objects;

// create User class and encapsulating Reimbursement states
public class Reimbursement {

    private String reimbId;
    private Float amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private Byte receipt;
    private String paymentId;
    private String authorId;
    private String resolverId;
    private String statusId;
    private String typeId;

    public Reimbursement() {
        super();
    }
    //creating constructor for parameters
    public Reimbursement(String reimbId, Float amount, Timestamp submitted, Timestamp resolved, String description, Byte receipt, String paymentId, String authorId, String resolverId, String statusId, String typeId) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.paymentId = paymentId;
        this.authorId = authorId;
        this.resolverId = resolverId;
        this.statusId = statusId;
        this.typeId = typeId;
    }
    //getters and setters for encapsulated data
    public String getReimbId() {
        return this.reimbId;
    }

    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getReceipt() {
        return receipt;
    }

    public void setReceipt(Byte receipt) {
        this.receipt = receipt;
    }

    public String getIsActive() {
        return paymentId;
    }

    public void setIsActive(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getResolverId() {
        return resolverId;
    }

    public void setResolverId(String resolverId) {
        this.resolverId = resolverId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    //overriding the equals method to compare data
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement reimbursement = (Reimbursement) o;
        return Objects.equals(reimbId, reimbursement.reimbId)
                && Objects.equals(amount, reimbursement.amount)
                && Objects.equals(submitted, reimbursement.submitted)
                && Objects.equals(resolved, reimbursement.resolved)
                && Objects.equals(description, reimbursement.description)
                && Objects.equals(receipt, reimbursement.receipt)
                && Objects.equals(paymentId, reimbursement.paymentId)
                && Objects.equals(authorId, reimbursement.authorId)
                && Objects.equals(resolverId, reimbursement.resolverId)
                && Objects.equals(statusId, reimbursement.statusId)
                && Objects.equals(typeId, reimbursement.typeId);
    }
    //overriding hashCode method so we get proper values
    @Override
    public int hashCode() {
        return Objects.hash(reimbId, amount, submitted, resolved, description, receipt, paymentId, authorId, resolverId, statusId, typeId);
    }
    //overriding toString method for client/user readability
    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId='" + reimbId + '\'' +
                ", amount='" + amount + '\'' +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", resolverId='" + resolverId + '\'' +
                ", statusId='" + statusId + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }

}