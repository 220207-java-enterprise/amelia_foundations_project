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
import com.revature.app.services.UserService;
import com.revature.app.util.exceptions.InvalidRequestException;
import com.revature.app.util.exceptions.ResourceConflictException;
import javax.security.sasl.AuthenticationException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.app.dtos.requests.ReimbursementRequest;
import com.revature.app.models.Reimbursement;
import com.revature.app.models.ReimbursementTypes;
import com.revature.app.models.ReimbursementStatuses;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }
}
