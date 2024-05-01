
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
a servlet to get form parameters to add a review to the database
 */

@WebServlet(
        urlPatterns = {"/addReview"}
)

public class AddReview extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao reviewDao = new GenericDao(Review.class);
        GenericDao userDao = new GenericDao(User.class);


        Review review = new Review();
        //get user
        int userID = Integer.parseInt(req.getParameter("userID"));
        User user = (User)userDao.getById(userID);
        //set review info from form parameters
        review.setUser(user);
        review.setPark(req.getParameter("park"));
        review.setCampground(req.getParameter("campground"));
        review.setCampsite(req.getParameter("campsite"));
        review.setSize(req.getParameter("size"));
        review.setShade(req.getParameter("shade"));
        review.setBathroomAccess(req.getParameter("bathroomAccess"));
        review.setKidFriendliness(req.getParameter("kidFriendliness"));
        review.setDogFriendliness(req.getParameter("dogFriendliness"));
        review.setReviewText(req.getParameter("reviewText"));
        //add review to database
        int addedReviewID = reviewDao.insert(review);
        //set header and reviews so that they can be displayed in the results jsp
        req.setAttribute("reviews", reviewDao.findByPropertyEqual("id", addedReviewID));
        req.setAttribute("tableHeader", "Review Added");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
