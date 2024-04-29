package edu.matc.controller;


import edu.matc.entity.Review;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/userPage"}
)

public class UserPage extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//
//        //gets form data and uses it to execute a search or get all reviews
//           GenericDao userDao = new GenericDao(User.class);
//
//        logger.debug(req.getParameter("userName"));
//        String userName = req.getParameter("userName");
//        logger.debug("The username:" + userName);
//
//        //stub for user to test userpage before connecting to aws
//        if (userList.isEmpty()) {
//            req.setAttribute("loginError", "User not found");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
//            dispatcher.forward(req, resp);
//        } else {
//            logger.debug(userList);
//            req.setAttribute("User", user);
//            req.setAttribute("userReviews", userReviews);

//        logger.debug(review);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/userPage.jsp");
            dispatcher.forward(req, resp);
        }
    }

