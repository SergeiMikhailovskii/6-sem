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

@WebServlet("/searchCustomerByStateCodeAndCreditLimit")
public class SearchCustomerByStateCodeAndCreditLimitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String stateCode = req.getParameter("stateCode");
            long creditLimit = Long.parseLong(req.getParameter("creditLimit"));
//            Context context = new InitialContext();
//            CustomerInterface customerInterface = (CustomerInterface) context.lookup(CustomerBean.class.getName());
//            Customer customer = customerInterface.getCustomerByStateCodeAndCreditLimit(stateCode, creditLimit);
            req.setAttribute("customer", customer);
            RequestDispatcher dispatcher = req.getRequestDispatcher("showAllCustomers.jsp");
            dispatcher.forward(req, resp);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
