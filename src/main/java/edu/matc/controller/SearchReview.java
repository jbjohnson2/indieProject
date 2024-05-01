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

/**
 * a servlet to route the user to the correct search results
 *
 * @author pwaite
 */
@WebServlet(
        urlPatterns = {"/searchReview"}
)

public class SearchReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        GenericDao reviewDao = new GenericDao(Review.class);
        //search by park,keyword or get all reviews based on search form
        if (req.getParameter("submit").equals("searchByPark")) {
            req.setAttribute("reviews", reviewDao.findByPropertyEqual("park", req.getParameter("parkName")));
        } else if(req.getParameter("submit").equals("searchByKeyword")) {
            req.setAttribute("reviews", reviewDao.getByPropertyLike("reviewText", req.getParameter("keyword")));
        } else {
            req.setAttribute("reviews", reviewDao.getAll());
        }
        req.setAttribute("tableHeader", "Search Results");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
