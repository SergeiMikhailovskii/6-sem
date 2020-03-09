package com.mikhailovskii.lab2;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showTwoSmallestFaculties")
public class ShowTwoSmallestFacultiesServlet extends HttpServlet {

    @EJB
    LabEjb ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ArrayList<Faculty> faculties = ejb.getTwoSmallestFaculties();

        if (faculties.size() >= 2) {
            req.setAttribute("facultyList", faculties);
            RequestDispatcher dispatcher = req.getRequestDispatcher("smallestFaculties.jsp");
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            }

        }
    }

}
