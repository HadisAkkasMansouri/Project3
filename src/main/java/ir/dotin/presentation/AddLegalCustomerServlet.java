package ir.dotin.presentation;

import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.dataaccess.LegalCustomerDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddLegalCustomerServlet extends HttpServlet{

    LegalCustomer legalCustomer = new LegalCustomer();
    LegalCustomerDao dao = new LegalCustomerDao();

    protected void addLegalCustomerRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        legalCustomer.setCompanyName(request.getParameter("CompaneyName"));
        legalCustomer.setEconomicId(request.getParameter("EconomicId"));
        legalCustomer.setRegistrationDate(request.getParameter("RegistrationDate"));

        boolean result = dao.addLegalCustomer(legalCustomer);
        if (result){
            response.sendRedirect("addLegalCustomer.html");
        }else {
            response.sendRedirect("addLegalCustomer.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        addLegalCustomerRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        addLegalCustomerRequest(request, response);
    }
}
