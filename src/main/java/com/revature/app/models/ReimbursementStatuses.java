package com.revature.app.models;

//creating ReimbursementStatus class and encapsulating states
public class ReimbursementStatuses {

    private String statusId;
    private String status;

    public ReimbursementStatuses() {
        super();
    }
    //creating constructor for parameters
    public ReimbursementStatuses(String statusId, String status) {
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
    //overriding toString method for client/user readability
    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "status_id='" + statusId + '\'' +
                ", status='" + status + '\'' + '}';
    }
}
