package edu.matc.controller;

import edu.matc.entity.Review;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * a servlet to welcome the user and set recent reviews
 */

@WebServlet(
        urlPatterns = {"/browseSites"}
)

public class browseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //gets form data and uses it to execute a search or get all reviews
        GenericDao genericDao = new GenericDao(Review.class);
        List<Review> reviews = genericDao.getAll();
        int numberOfReviews = reviews.size();

        req.setAttribute("recentReview1", genericDao.getById(numberOfReviews));
        req.setAttribute("recentReview2", genericDao.getById(numberOfReviews-1));
        req.setAttribute("recentReview3", genericDao.getById(numberOfReviews-2));
        req.setAttribute("allReviews", reviews);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/browseSites.jsp");
        dispatcher.forward(req, resp);
    }


}
