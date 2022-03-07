package com.revature.app.dtos.requests;

import com.revature.app.models.Reimbursement;
import com.revature.app.models.ReimbursementStatuses;
import com.revature.app.models.ReimbursementTypes;
import com.revature.app.models.User;

import java.util.Objects;

public class UpdateReimbursementRequest extends ReimbursementRequest {
    private String reimbId;
    private String resolverId;
    private String status;

    public UpdateReimbursementRequest() {
        super();
    }

    public void UpdateReimbursementRequest(String reimbId, String resolverId, String status) {
        this.reimbId = reimbId;
        this.resolverId = resolverId;
        this.status = status;
    }

    public String getReimbId() {
        return reimbId;
    }

    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }

    public String getResolverId() {
        return resolverId;
    }

    public void setResolverId(String resolverId) {
        this.resolverId = resolverId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpdateReimbursementRequest{" +
                "reimb_id='" + reimbId + '\'' +
                ", resolver_id='" + resolverId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateReimbursementRequest)) return false;
        UpdateReimbursementRequest that = (UpdateReimbursementRequest) o;
        return Objects.equals(getReimbId(), that.getReimbId()) && Objects.equals(getResolverId(), that.getResolverId()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReimbId(), getResolverId(), getStatus());
    }
}