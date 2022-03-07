package com.revature.app.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.fasterxml.jackson.databind.DatabindException;
import com.revature.app.dtos.requests.UpdateReimbursementRequest;
import com.revature.app.dtos.responses.Principal;
import com.revature.app.dtos.responses.ResourceCreationResponse;
import com.revature.app.util.exceptions.InvalidRequestException;
import com.revature.app.util.exceptions.ResourceConflictException;
import javax.security.sasl.AuthenticationException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.app.dtos.requests.ReimbursementRequest;
import com.revature.app.models.Reimbursement;
import com.revature.app.services.ReimbursementService;
import com.revature.app.services.TokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/reimbursement") // Annotation-based declarative registration (dependency wiring does not work!)
public class ReimbursementServlet extends HttpServlet {

    private static Logger logger = LogManager.getLogger(ReimbursementServlet.class);

    private final TokenService tokenService;
    private final ReimbursementService reimbursementService;
    private final ObjectMapper mapper;

    public ReimbursementServlet(TokenService tokenService, ReimbursementService reimbursementService, ObjectMapper mapper) {
        this.tokenService = tokenService;
        this.reimbursementService = reimbursementService;
        this.mapper = mapper;
    }

    // Reimbursement submit endpoint
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        try {

            Principal potentiallyEmployee = tokenService.extractRequesterDetails(req.getHeader("Authorization"));
            if (!(potentiallyEmployee.getRole().equals("EMPLOYEE"))) {
                throw new InvalidRequestException("Only Employees can submit Reimbursements");
            }

            ReimbursementRequest reimbursementRequest = mapper.readValue(req.getInputStream(), ReimbursementRequest.class);

            reimbursementService.createReimbursementRequest(reimbursementRequest);
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            String payload = mapper.writeValueAsString(reimbursementRequest);
            resp.setContentType("application/json");
            writer.write(payload);

        } catch (InvalidRequestException | DatabindException e) {
            e.printStackTrace();
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            resp.setStatus(401); // UNAUTHORIZED (no user found with provided credentials)
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }

    //only FINANCE MANAGER can update
    @Override
    public void doPut (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter respWriter = resp.getWriter();

        try {

            Principal potentiallyAdmin = tokenService.extractRequesterDetails(req.getHeader("Authorization"));
            if (!(potentiallyAdmin.getRole().equals("FINANCE MANAGER"))) {
                throw new InvalidRequestException("Unauthorized Role");
            }

            UpdateReimbursementRequest updateReimbursementRequest = mapper.readValue(req.getInputStream(), UpdateReimbursementRequest.class);

            Reimbursement updatedReimbursement = reimbursementService.updateReimbursementStatus(updateReimbursementRequest);

            resp.setStatus(201); // Successful
            resp.setContentType("application/json");
            String payload = mapper.writeValueAsString(new ResourceCreationResponse(updatedReimbursement.getResolverId()));
            respWriter.write(payload);

        } catch (InvalidRequestException | DatabindException e) {
            resp.setStatus(400); // BAD REQUEST
            e.printStackTrace();
        } catch (ResourceConflictException e) {
            e.printStackTrace();
            resp.setStatus(409); // CONFLICT
        } catch (Exception e) {
            e.printStackTrace(); //for debugging - logged it to a file
            resp.setStatus(500);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("ReimbursementServlet#doGet invoked with args: " + Arrays.asList(req, resp));

        Principal requester = tokenService.extractRequesterDetails(req.getHeader("Authorization"));

        if (requester == null) {
            resp.setStatus(401);
            return;
        }
        if (!(requester.getRole().equals("FINANCE MANAGER") || requester.getRole().equals("EMPLOYEE"))) {
            resp.setStatus(403); // FORBIDDEN
            return;
        }

        PrintWriter writer = resp.getWriter();

        try {

            requester = tokenService.extractRequesterDetails(req.getHeader("Authorization"));
            if (!(requester.getRole().equals("EMPLOYEE"))) {
                throw new InvalidRequestException("Only Employees can submit Reimbursements");
            }

            ReimbursementRequest reimbursementRequest = mapper.readValue(req.getInputStream(), ReimbursementRequest.class);

            reimbursementService.createReimbursementRequest(reimbursementRequest);
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            String payload = mapper.writeValueAsString(reimbursementRequest);
            resp.setContentType("application/json");
            writer.write(payload);

            List<Reimbursement> users = reimbursementService.getAll();
            switch (requester.getRole()) {
                case "FINANCE MANAGER":
                    if (req.getHeader("Status-Filter").equals("PENDING")) {
                        List<Reimbursement> pendingUsers = new ArrayList<>();
                        for (Reimbursement reimbursement : users) {
                            if (reimbursement.getStatus().equals("PENDING")) {
                                pendingUsers.add(reimbursement);
                            }
                        }
                        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                        payload = mapper.writeValueAsString(pendingUsers);
                        resp.setContentType("application/json");
                        resp.getWriter().write(payload);

                    } else if (req.getHeader("Status-Filter").equals("APPROVED")) {
                        List<Reimbursement> approvedUsers = new ArrayList<>();
                        for (Reimbursement reimbursement : users) {
                            if (reimbursement.getStatus().equals("APPROVED")) {
                                approvedUsers.add(reimbursement);
                            }
                        }
                        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                        payload = mapper.writeValueAsString(approvedUsers);
                        resp.setContentType("application/json");
                        resp.getWriter().write(payload);

                    } else if (req.getHeader("Status-Filter").equals("DECLINED")) {
                        List<Reimbursement> declinedUsers = new ArrayList<>();
                        for (Reimbursement reimbursement : users) {
                            if (reimbursement.getStatus().equals("DECLINED")) {
                                declinedUsers.add(reimbursement);
                            }
                        }
                        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                        payload = mapper.writeValueAsString(declinedUsers);
                        resp.setContentType("application/json");
                        resp.getWriter().write(payload);

                    } else {
                        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                        payload = mapper.writeValueAsString(users);
                        resp.setContentType("application/json");
                        resp.getWriter().write(payload);
                    }
                case "EMPLOYEE":
                    List<Reimbursement> employeeReimbursements = new ArrayList<>();
                    for (Reimbursement reimbursement : users) {
                        if (reimbursement.getAuthorId().equals(tokenService.extractRequesterDetails(req.getHeader("Authorization")).getId())) {
                            employeeReimbursements.add(reimbursement);
                        }
                    } if (req.getHeader("Status-Filter").equals("PENDING")) {
                        List<Reimbursement> pendingUsers = new ArrayList<>();
                        for (Reimbursement reimbursement : employeeReimbursements) {
                            if (reimbursement.getStatus().equals("PENDING")) {
                                pendingUsers.add(reimbursement);
                            }
                        }
                        System.out.println(pendingUsers);
                        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                        payload = mapper.writeValueAsString(pendingUsers);
                        resp.setContentType("application/json");
                        resp.getWriter().write(payload);

                    } else if (req.getHeader("Status-Filter").equals("APPROVED")) {
                        List<Reimbursement> approvedUsers = new ArrayList<>();
                        for (Reimbursement reimbursement : employeeReimbursements) {
                            if (reimbursement.getStatus().equals("APPROVED")) {
                                approvedUsers.add(reimbursement);
                            }
                        }
                        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                        payload = mapper.writeValueAsString(approvedUsers);
                        resp.setContentType("application/json");
                        resp.getWriter().write(payload);

                    } else if (req.getHeader("Status-Filter").equals("DECLINED")) {
                        List<Reimbursement> declinedUsers = new ArrayList<>();
                        for (Reimbursement reimbursement : employeeReimbursements) {
                            if (reimbursement.getStatus().equals("DECLINED")) {
                                declinedUsers.add(reimbursement);
                            }
                        }
                        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                        payload = mapper.writeValueAsString(declinedUsers);
                        resp.setContentType("application/json");
                        resp.getWriter().write(payload);

                    } else {
                        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                        payload = mapper.writeValueAsString(employeeReimbursements);
                        resp.setContentType("application/json");
                        resp.getWriter().write(payload);
                    }
            }

        } catch (InvalidRequestException | DatabindException e) {
            e.printStackTrace();
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            resp.setStatus(401); // UNAUTHORIZED (no user found with provided credentials)
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
    }
            }
        }
