package com.revature.app.models;

import java.util.Objects;
//creating ReimbursementType class and encapsulating states
public class ReimbursementType {

    private String typeId;
    private String typeReimb;

    public ReimbursementType() {
        super();
    }

    //creating constructor for parameters
    public ReimbursementType(String typeId, String typeReimb) {
        this.typeId = typeId;
        this.typeReimb = typeReimb;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getStatus() {
        return typeReimb;
    }

    public void setStatus(String typeReimb) {
        this.typeReimb = typeReimb;
    }

    //overriding the equals method to compare data
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementType reimbursementType = (ReimbursementType) o;
        return Objects.equals(typeId, reimbursementType.typeId) && Objects.equals(typeReimb, reimbursementType.typeReimb);
    }
    //overriding hashCode method so we get proper values
    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeReimb);
    }

    //overriding toString method for client/user readability
    @Override
    public String toString() {
        return "ReimbursementType{" +
                "typeId='" + typeId + '\'' +
                ", typeReimb='" +
                typeReimb +
                '\'' +
                '}';
    }

}
