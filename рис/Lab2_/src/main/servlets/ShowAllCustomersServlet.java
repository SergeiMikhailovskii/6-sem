package main.servlets;

import main.Customer;
import main.CustomerBean;
import main.CustomerInterface;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showAllCustomers")
public class ShowAllCustomersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            CustomerInterface customerInterface = (CustomerInterface) context.lookup(CustomerBean.class.getName());
            ArrayList<Customer> customers = customerInterface.getAllCustomers();
            System.out.println(customers.get(0).getAddress());

            RequestDispatcher dispatcher = req.getRequestDispatcher("showAllCustomers.jsp");
            req.setAttribute("customers", customers);
            dispatcher.forward(req, resp);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
