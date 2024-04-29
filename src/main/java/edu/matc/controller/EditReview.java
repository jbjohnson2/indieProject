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

        //gets form data and uses it to execute a search or get all reviews
        GenericDao reviewDao = new GenericDao(Review.class);
        GenericDao userDao = new GenericDao(User.class);
        logger.debug(req.getParameter("userId"));
        logger.debug(req.getParameter("reviewId"));
        Review reviewToEdit = (Review)reviewDao.getById(Integer.parseInt(req.getParameter("reviewId")));
        int reviewId = reviewToEdit.getId();
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = (User)userDao.getById(userId);
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
        reviewDao.update(reviewToEdit);
        req.setAttribute("reviews", reviewDao.findByPropertyEqual("id", reviewToEdit.getId()));
        req.setAttribute("tableHeader", "Review Updated");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
