package com.revature.app.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.app.daos.UserDAO;
import com.revature.app.services.TokenService;
import com.revature.app.services.UserService;
import com.revature.app.servlets.AuthServlet;
import com.revature.app.servlets.UserServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    private static Logger logger = LogManager.getLogger(ContextLoaderListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("Initializing ERS web application");

        ObjectMapper mapper = new ObjectMapper();
        JwtConfig jwtConfig = new JwtConfig();
        TokenService tokenService = new TokenService(jwtConfig);

        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);
        UserServlet userServlet = new UserServlet(tokenService, userService, mapper);
        AuthServlet authServlet = new AuthServlet(tokenService, userService, mapper);

        // Programmatic Servlet Registration
        ServletContext context = sce.getServletContext();
        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("Shutting down Quizzard web application");
    }

}