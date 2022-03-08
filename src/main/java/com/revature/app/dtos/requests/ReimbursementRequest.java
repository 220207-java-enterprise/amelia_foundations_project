package com.revature.app.dtos.requests;
import com.revature.app.models.Reimbursement;

public class ReimbursementRequest extends Reimbursement {
    private Float amount;
    private String description;
    private String authorId;
    private String typeId;

    public Float getAmount() {
        return amount;
    }
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
        return new Reimbursement(amount, description, typeId);
    }
}

