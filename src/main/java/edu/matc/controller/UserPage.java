package edu.matc.controller;


import edu.matc.entity.Review;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * a servlet to update the user reviews list
 */
@WebServlet(
        urlPatterns = {"/userPage"}
)

public class UserPage extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //get user and reset userReviews so that they are current
        GenericDao userDao = new GenericDao(User.class);
        HttpSession session = req.getSession();
        User user = (User) userDao.getById((Integer) session.getAttribute("userId"));
        List<Review> userReviews = user.getReviews();

        req.setAttribute("userReviews", userReviews);


            RequestDispatcher dispatcher = req.getRequestDispatcher("/userPage.jsp");
            dispatcher.forward(req, resp);
        }
    }

