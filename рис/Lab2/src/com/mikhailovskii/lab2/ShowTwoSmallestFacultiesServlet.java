package com.mikhailovskii.lab2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showTwoSmallestFaculties")
public class ShowTwoSmallestFacultiesServlet extends HttpServlet {

    // @EJB
    LabEjb ejb = new LabEjb();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ArrayList<String> faculties = ejb.getTwoSmallestFaculties();

        if (faculties.size() >= 2) {
            resp.getWriter().write(faculties.get(0) + "\n");
            resp.getWriter().write(faculties.get(1) + "\n");
        }
    }

}
