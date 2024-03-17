
package edu.matc.controller;


import edu.matc.entity.Review;
import edu.matc.entity.User;
import edu.matc.persistence.ReviewDao;
import edu.matc.persistence.UserDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
        import java.io.IOException;


@WebServlet(
        urlPatterns = {"/addReview"}
)

public class AddReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //gets form data and uses it to execute a search or get all reviews
        ReviewDao reviewDao = new ReviewDao();
        UserDao  userDao = new UserDao();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("reviews", reviewDao.getByPropertyEqual("park", req.getParameter("parkName")));
        } else {
            req.setAttribute("reviews", reviewDao.getAll());
        }
        Review review = new Review();
        int userID = Integer.parseInt(req.getParameter("userID"));
        review.setUser(userDao.getById(userID));
        review.setPark(req.getParameter("park"));
        review.setSize(req.getParameter("size"));
        review.setBathroomAccess(req.getParameter("bathroomAccess"));
        review.setKidFriendliness(req.getParameter("kidFriendliness"));
        review.setDogFriendliness(req.getParameter("dogFriendliness"));
        review.setReviewText(req.getParameter("reviewText"));
        reviewDao.insert(review);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
