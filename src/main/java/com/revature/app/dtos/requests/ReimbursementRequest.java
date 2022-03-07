package com.revature.app.dtos.requests;
import com.revature.app.models.Reimbursement;
import com.revature.app.models.ReimbursementTypes;
import com.revature.app.models.User;

public class ReimbursementRequest extends Reimbursement {

    private double amount;
    private String description;
    private byte receipt;
    private String authorId;
    private String typeId;

    public ReimbursementRequest() {
        super();

    }

    public ReimbursementRequest(double amount, String description, byte receipt, String authorId, String typeId) {
        this.amount = amount;
        this.description = description;
        this.receipt = receipt;
        this.authorId = authorId;
        this.typeId = typeId;
    }

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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Reimbursement extractReimbursement() {
        return new Reimbursement(amount, description, receipt, authorId, typeId);
    }

    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", author_id='" + authorId + '\'' +
                ", type_id='" + typeId + '\'' +
                '}';
    }

}
