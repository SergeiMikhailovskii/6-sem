package lab3.servlets;

import lab3.CustomerBean;
import lab3.CustomerInterface;

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

@WebServlet("/addNewCustomer")
public class AddNewCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("addNewCustomer.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/web_war_exploded/");
        String discount = req.getParameter("discount");
        String zip = req.getParameter("zip");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String stateCode = req.getParameter("stateCode");
        long creditLimit = Long.parseLong(req.getParameter("creditLimit"));

        try {
            Context context = new InitialContext();
            CustomerInterface customerInterface = (CustomerInterface) context.lookup(CustomerBean.class.getName());
            customerInterface.addCustomer(discount, zip, name, address, stateCode, creditLimit);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

}
