package edu.matc.controller;


import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 *a servlet to add a zipcode to a user
 */
@WebServlet(
        urlPatterns = {"/addZipcode"}
)

public class AddZipcode extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        GenericDao userDao = new GenericDao(User.class);
        //get user
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = (User) userDao.getById(userId);
        //set user zipcode
        user.setZipcode(Integer.parseInt(req.getParameter("userZip")));
        //update user
        userDao.update(user);
        //update user reviews and user
        req.setAttribute("userReviews", user.getReviews());
        req.setAttribute("User", user);
        //forward to distance search to display results
        RequestDispatcher dispatcher = req.getRequestDispatcher("/distanceSearch.jsp");
        dispatcher.forward(req, resp);
    }
}