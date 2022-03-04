package com.revature.app.dtos.requests;
import com.revature.app.models.Reimbursement;

public class ReimbursementRequest extends Reimbursement {

    private double amount;
    private String description;
    private byte receipt;
    private String paymentId;
    private String authorId;
    private String typeID;

    public ReimbursementRequest() {
        super();

    }

    /*public ReimbursementRequest(double amount, String description, byte receipt, String paymentId, String authorId, String typeID) {
        this.amount = amount;
        this.description = description;
        this.receipt = receipt;
        this.paymentId = paymentId;
        this.authorId = authorId;
        this.typeID = typeID;
    }*/

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", payment_id='" + paymentId + '\'' +
                ", author_id='" + authorId + '\'' +
                ", type_id='" + typeID + '\'' +
                '}';
    }

}
