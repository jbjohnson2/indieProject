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
import java.io.IOException;

/**
 *a servlet to edit a review
 */
@WebServlet(
        urlPatterns = {"/editReview"}
)

public class EditReview extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //gets form data and uses it to edit a review
        GenericDao reviewDao = new GenericDao(Review.class);
        GenericDao userDao = new GenericDao(User.class);
        //get id  of review to edit
        Review reviewToEdit = (Review)reviewDao.getById(Integer.parseInt(req.getParameter("reviewId")));
        //get user
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = (User)userDao.getById(userId);
        //set review info from form
        reviewToEdit.setUser(user);
        reviewToEdit.setPark(req.getParameter("park"));
        reviewToEdit.setCampground(req.getParameter("campground"));
        reviewToEdit.setCampsite(req.getParameter("campsite"));
        reviewToEdit.setSize(req.getParameter("size"));
        reviewToEdit.setShade(req.getParameter("shade"));
        reviewToEdit.setBathroomAccess(req.getParameter("bathroomAccess"));
        reviewToEdit.setKidFriendliness(req.getParameter("kidFriendliness"));
        reviewToEdit.setDogFriendliness(req.getParameter("dogFriendliness"));
        reviewToEdit.setReviewText(req.getParameter("reviewText"));
        //update review
        reviewDao.update(reviewToEdit);
        //set reviews and table header to be displayed on results page
        req.setAttribute("reviews", reviewDao.findByPropertyEqual("id", reviewToEdit.getId()));
        req.setAttribute("tableHeader", "Review Updated");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
