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


@WebServlet(
        urlPatterns = {"/editReviewRouter"}
)

public class EditReviewRouter extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        //gets review to edit and sends it to the jsp
        GenericDao reviewDao= new GenericDao(Review.class);

        Review reviewToEdit = (Review)reviewDao.getById(Integer.parseInt(req.getParameter("reviewID")));


        req.setAttribute("reviewToEdit", reviewToEdit);
        RequestDispatcher dispatcher = req.getRequestDispatcher("editReview.jsp");
        dispatcher.forward(req, resp);
    }

}
