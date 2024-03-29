package edu.matc.controller;


import edu.matc.persistence.ReviewDao;
import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 *
 * @author pwaite
 */
@WebServlet(
        urlPatterns = {"/searchReview"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //gets form data and uses it to execute a search or get all reviews
        ReviewDao reviewDao = new ReviewDao();//        UserData userData = new UserData();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("reviews", reviewDao.getByPropertyEqual("park", req.getParameter("parkName")));
        } else {
            req.setAttribute("reviews", reviewDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
