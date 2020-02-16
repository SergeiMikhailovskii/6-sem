package com.mikhailovskii.lab2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculatePaymentForSeveralSemesters")
public class CalculatePaymentForSeveralSemestersServlet extends HttpServlet {

    // @EJB
    LabEjb ejb = new LabEjb();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        double period = Double.parseDouble(req.getParameter("period"));
        String faculty = req.getParameter("faculty");

        try {
            double sum = ejb.calculatePaymentForSeveralSemesters(period, faculty);
            resp.getWriter().write("<h1>You should to pay: " + sum + "</h1>");
        } catch (FacultyNotFoundException e) {
            e.printStackTrace();
        }
    }

}
