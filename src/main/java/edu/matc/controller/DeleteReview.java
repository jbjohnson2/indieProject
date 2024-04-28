package edu.matc.controller;


import edu.matc.entity.Review;
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
import java.util.List;

/**
 * servlet to delete a review
 */
@WebServlet(
        urlPatterns = {"/deleteReview"}
)

public class DeleteReview extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //gets form data and uses it to execute a search or get all reviews


        GenericDao genericDao= new GenericDao(Review.class);
        Review reviewToDelete = (Review)genericDao.getById(Integer.parseInt(req.getParameter("reviewID")));
        genericDao.delete(reviewToDelete);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/userPage");
        dispatcher.forward(req, resp);
    }
}
