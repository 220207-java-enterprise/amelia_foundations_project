package com.revature.app.models;

//creating ReimbursementType class and encapsulating states
public class ReimbursementType {
    private String typeId;
    private String type;

    public ReimbursementType() {
        super();
    }

    //creating constructor for parameters
    public ReimbursementType(String typeId, String type) {
        this.typeId = typeId;
        this.type = type;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //overriding toString method for client/user readability
    @Override
    public String toString() {
        return "ReimbursementType{" +
                "typeId='" + typeId + '\'' +
                ", type='" + type + '\'' + '}';
    }
}
