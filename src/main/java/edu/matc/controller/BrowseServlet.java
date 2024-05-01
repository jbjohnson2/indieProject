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
 * a servlet to set recent reviews and display a searchable list of all reviews
 */

@WebServlet(
        urlPatterns = {"/browseSites"}
)

public class BrowseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        GenericDao genericDao = new GenericDao(Review.class);
        //get all reviews
        List<Review> reviews = genericDao.getAll();
        int numberOfReviews = reviews.size();
        //set attributes for recent reviews and all reviews to be displayed on the browse page
        req.setAttribute("recentReview1", genericDao.getById(numberOfReviews));
        req.setAttribute("recentReview2", genericDao.getById(numberOfReviews-1));
        req.setAttribute("recentReview3", genericDao.getById(numberOfReviews-2));
        req.setAttribute("allReviews", reviews);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/browseSites.jsp");
        dispatcher.forward(req, resp);
    }


}
