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


        //gets form data and uses it to execute a search or get all reviews
        GenericDao reviewDao = new GenericDao(Review.class);
        GenericDao userDao = new GenericDao(User.class);


        Review review = new Review();
        String username = req.getParameter("userName");
        logger.debug("The username:" + username);

        //stub for user to test userpage before connecting to aws
        List<User> userList = userDao.findByPropertyEqual("userName", username);
        logger.debug(userList);
        User user = (User) userDao.getById(userList.get(0).getId());
        List<Review> userReviews = user.getReviews();
        req.setAttribute("User", user);
        req.setAttribute("userReviews", userReviews);
        req.setAttribute("message", "");

//        logger.debug(review);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userPage.jsp");
        dispatcher.forward(req, resp);
    }

}
