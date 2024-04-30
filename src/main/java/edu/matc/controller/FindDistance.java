package edu.matc.controller;


import edu.matc.entity.StatePark;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.ZipcodeApiDao;
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
 * a servlet to find the distance to a state park from the user's zip code and display the distance in a message
 */
@WebServlet(
        urlPatterns = {"/findDistance"}
)

public class FindDistance extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //gets form data and uses it to execute a search or get all reviews


        GenericDao genericDao= new GenericDao(StatePark.class);
        ZipcodeApiDao zipcodeApiDao = new ZipcodeApiDao();
        StatePark statePark = (StatePark) genericDao.getById(Integer.parseInt(req.getParameter("park")));
        int parkZip = statePark.getZipcode();
        int userZip = Integer.parseInt(req.getParameter("userZipcode"));
        int distance = (int) zipcodeApiDao.getDistance(userZip, parkZip);

        req.setAttribute("distance", distance);
        req.setAttribute("message", ("The distance to " + statePark.getParkName() + " is " + distance + " miles."));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/distanceSearch.jsp");
        dispatcher.forward(req, resp);
    }
}
