package com.revature.app.models;
//import java SQL timestamp and superclass Objects
import java.sql.Timestamp;
import java.util.Objects;

// create User class and encapsulating Reimbursement states
public class Reimbursement {
    private String reimbId;
    private double amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private byte receipt;
    private String paymentId;
    private String authorId;
    private String resolverId;
    private String statusId;
    private String status;
    private String typeId;
    private String type;

    public Reimbursement() {
        super();
    }
    //creating constructor for parameters
    public Reimbursement(String reimbId, double amount, Timestamp submitted, Timestamp resolved, String description, Byte receipt, String paymentId, String authorId, String resolverId, String statusId, String status, String typeId, String type) {
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
        this.status = status;
        this.type = typeId;
        this.typeId = type;
    }

    public Reimbursement(double amount, String description, byte receipt, String authorId, String typeId) {
    }

    //getters and setters for encapsulated data
    public String getReimbId() {
        return reimbId;
    }

    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public byte getReceipt() {
        return receipt;
    }

    public void setReceipt(byte receipt) {
        this.receipt = receipt;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
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

    public void setStatusId(String statusId, String status) {
        this.statusId = statusId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement reimbursement = (Reimbursement) o;
        return Double.compare(reimbursement.amount, amount) == 0
                            && receipt == reimbursement.receipt
                            && Objects.equals(reimbId, reimbursement.reimbId)
                            && Objects.equals(submitted, reimbursement.submitted)
                            && Objects.equals(resolved, reimbursement.resolved)
                            && Objects.equals(description, reimbursement.description)
                            && Objects.equals(paymentId, reimbursement.paymentId)
                            && Objects.equals(authorId, reimbursement.authorId)
                            && Objects.equals(resolverId, reimbursement.resolverId)
                            && Objects.equals(statusId, reimbursement.statusId)
                            && Objects.equals(status, reimbursement.status)
                            && Objects.equals(typeId, reimbursement.typeId)
                            && Objects.equals(type, reimbursement.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbId, amount, submitted, resolved, description, receipt, paymentId, authorId, resolverId, statusId, status, typeId, type);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimb_id='" + reimbId + '\'' +
                ", amount='" + amount + '\'' +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", payment_id='" + paymentId + '\'' +
                ", author_id='" + authorId + '\'' +
                ", resolver_id='" + resolverId + '\'' +
                ", status_id='" + statusId + '\'' +
                ", status='" + status + '\'' +
                ", type_id='" + typeId + '\'' +
                ", type='" + type + '\'' +'}';
    }

    public void setStatusId(ReimbursementStatuses reimbursementStatuses) {
    }

    public void setStatus(ReimbursementStatuses newReimbursementStatus) {
    }
}