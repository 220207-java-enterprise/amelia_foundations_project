package com.revature.app.servlets;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.app.dtos.responses.Principal;
import com.revature.app.dtos.responses.ReimbursementResponse;
import javax.security.sasl.AuthenticationException;
import com.revature.app.dtos.requests.ReimbursementRequest;
import com.revature.app.models.Reimbursement;
import com.revature.app.services.ReimbursementService;
import com.revature.app.services.TokenService;
import com.revature.app.util.exceptions.InvalidRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.util.List;

@WebServlet("/reimbursement/*") // Annotation-based declarative registration (dependency wiring does not work!)
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
    ///I had lots of help from Ryan and Aidan and borrowed some code to complete and understand what is happening
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String jwt = req.getHeader("Authentication");
        Principal principal = null;

        if (jwt != null)
            principal = tokenService.extractRequesterDetails(jwt);

        if (principal == null) {
            resp.setStatus(401);
            return;

        } else if (!principal.getRole().equals("FINANCE MANAGER")) {
            resp.setStatus(403);
            return;
        }

        List<ReimbursementResponse> reimbursements = reimbursementService.getAll();
        resp.getWriter().write(mapper.writeValueAsString(reimbursements));
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            PrintWriter writer = resp.getWriter();

        try {

            Principal requester = tokenService.extractRequesterDetails(req.getHeader("Authorization"));

            if (requester.getRole().equals("EMPLOYEE")) {
                ReimbursementRequest reimbursementRequest = mapper.readValue(req.getInputStream(), ReimbursementRequest.class);
                reimbursementRequest.setAuthorId(requester.getId());
                reimbursementService.request(reimbursementRequest);
                String payload = mapper.writeValueAsString(reimbursementRequest);
                resp.setContentType("application/json");
                writer.write(payload);
                System.out.println(payload);
            } else {
                resp.setStatus(403); // FORBIDDEN
                return;
            }

        } catch (InvalidRequestException | DatabindException e) {
            e.printStackTrace();
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            resp.setStatus(401); // UNAUTHORIZED (no user found with provided credentials)
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] reqFrags = req.getRequestURI().split("/");

        if (reqFrags.length == 4 && reqFrags[3].equals("status")) {
            String jwt = req.getHeader("Authentication");
            Principal principal = null;

            if (jwt != null)
                principal = tokenService.extractRequesterDetails(jwt);

            if (principal == null) {
                resp.setStatus(401);
            } else if (!principal.getRole().equals("FINANCE MANAGER")) {
                resp.setStatus(403);
            }
        }
    }
}

