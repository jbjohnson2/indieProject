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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(
        urlPatterns = {"/editReviewRouter"}
)

public class EditReviewRouter extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //gets form data and uses it to execute a search or get all reviews


        GenericDao reviewDao= new GenericDao(Review.class);

        Review reviewToEdit = (Review)reviewDao.getById(Integer.parseInt(req.getParameter("reviewID")));


        req.setAttribute("reviewToEdit", reviewToEdit);
        RequestDispatcher dispatcher = req.getRequestDispatcher("editReview.jsp");
        dispatcher.forward(req, resp);
    }



}
