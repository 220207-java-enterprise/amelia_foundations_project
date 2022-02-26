package com.revature.app.models;

import java.util.Objects;
//creating ReimbursementStatus class and encapsulating states
public class ReimbursementStatus {

    private String statusId;
    private String status;

    public ReimbursementStatus() {
        super();
    }
    //creating constructor for parameters
    public ReimbursementStatus(String statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //overriding the equals method to compare data
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementStatus reimbursementStatus = (ReimbursementStatus) o;
        return Objects.equals(statusId, reimbursementStatus.statusId) && Objects.equals(status, reimbursementStatus.status);
    }
    //overriding hashCode method so we get proper values
    @Override
    public int hashCode() {
        return Objects.hash(statusId, status);
    }
    //overriding toString method for client/user readability
    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "statusId='" + statusId + '\'' +
                ", status='" +
                status +
                '\'' +
                '}';
    }

}
