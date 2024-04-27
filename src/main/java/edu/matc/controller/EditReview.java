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
 *
 *
 * @author jcecil
 */
@WebServlet(
        urlPatterns = {"/editReview"}
)

public class EditReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //gets form data and uses it to execute a search or get all reviews
        GenericDao genericDao = new GenericDao(Review.class);
        Review reviewToEdit = (Review)genericDao.getById(Integer.parseInt(req.getParameter("reviewID")));
        req.setAttribute("review", reviewToEdit);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editReview.jsp");
        dispatcher.forward(req, resp);
    }
}
