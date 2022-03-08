package com.revature.app.services;

import com.revature.app.daos.ReimbursementDAO;
import com.revature.app.daos.UserDAO;
import com.revature.app.dtos.responses.Principal;
import com.revature.app.dtos.responses.ReimbursementResponse;
import com.revature.app.models.Reimbursement;
import com.revature.app.dtos.requests.ReimbursementRequest;
import com.revature.app.util.exceptions.InvalidRequestException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ReimbursementService {
    final private ReimbursementDAO reimbursementDAO;
    final private UserDAO userDAO;

    public ReimbursementService(ReimbursementDAO reimbursementDAO, UserDAO userDAO) {
        this.reimbursementDAO = reimbursementDAO;
        this.userDAO = userDAO;
    }

    public void request(Reimbursement reimbursement, ReimbursementRequest request) {
        Reimbursement newReimbursement = request.extractReimbursement();
        newReimbursement.setAuthorId(reimbursement.getAuthorId());

        reimbursementDAO.save(newReimbursement);   PROBLEM
    }

    public List<ReimbursementResponse> getAll() {
        return reimbursementDAO.getAll()
                .stream()
                .map(ReimbursementResponse::new)
                .collect(Collectors.toList());
    }

    public class UpdateReimbursementRequest {
        private String reimbId;
        private ReimbursementUpdates updates;

        public String getReimbId() {
            return reimbId;
        }
        public void setReimbId(String reimbId) {
            this.reimbId = reimbId;
        }

        public ReimbursementUpdates getUpdates() {
            return updates;
        }
        public void setUpdates(ReimbursementUpdates updates) {
            this.updates = updates;
        }

        public class ReimbursementUpdates {
            private Float amount;
            private Timestamp submitted;
            private Timestamp resolved;
            private String description;
            private String paymentId;
            private String AuthorId;
            private String ResolverId;
            private String statusId;
            private String type;

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

            public String getPaymentId() {
                return paymentId;
            }
            public void setPaymentId(String paymentId) {
                this.paymentId = paymentId;
            }

            public String getAuthorId() {
                return AuthorId;
            }
            public void setAuthorId(String authorId) {
                AuthorId = authorId;
            }

            public String getResolverId() {
                return ResolverId;
            }
            public void setResolverId(String resolverId) {
                ResolverId = resolverId;
            }

            public String getStatusId() {
                return statusId;
            }
            public void setStatusId(String statusId) {
                this.statusId = statusId;
            }

            public String getType() {
                return type;
            }
            public void setType(String type) {
                this.type = type;
            }

            public void setStatus(UpdateReimbursementRequest update, Reimbursement Reimbursement) {
                UpdateReimbursementRequest.ReimbursementUpdates updates = update.getUpdates();
                String status = updates.getStatusId();

                if (
                        !status.equals("DENIED") && !status.equals("APPROVED")
                )
                    throw new InvalidRequestException("Invalid status id provided.");


                reimbursementDAO.update(Reimbursement);
            }
        }
    }
}

