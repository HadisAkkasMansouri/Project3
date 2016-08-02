package ir.dotin.business;

import ir.dotin.dataAccess.LegalCustomerDao;
import ir.dotin.entities.LegalCustomer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddLegalCustomerServlet extends HttpServlet{
    LegalCustomer legalCustomer = new LegalCustomer();
    LegalCustomerDao dao = new LegalCustomerDao();

    protected void addLegalCustomerRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        legalCustomer.setCompanyName(request.getParameter("COMPANY_NAME"));
        legalCustomer.setEconomicId(request.getParameter("ECONOMIC_ID"));
        legalCustomer.setRegistrationDate(request.getParameter("REGISTRATION_DATE"));

        boolean result = dao.addLegalCustomer(legalCustomer);
//        if (result){
//            response.sendRedirect();
//        }else {
//            response.sendRedirect();
//        }
    }

    protected void sendResoponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        addLegalCustomerRequest(request, response);
    }

    protected void receiveRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        addLegalCustomerRequest(request, response);
    }
}
