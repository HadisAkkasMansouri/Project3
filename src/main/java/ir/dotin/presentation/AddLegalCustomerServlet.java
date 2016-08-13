package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NullRequiredFieldException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String companyName = request.getParameter("CompanyName");
        String economicId = request.getParameter("EconomicId");
        String registrationDate = request.getParameter("RegistrationDate");
        try {
            if (CustomerValidation.validateAddLegalCustomer(companyName, economicId, registrationDate)) {
                LegalCustomer legalCustomer = legalCustomerDAO.addLegalCustomer(companyName, economicId, registrationDate);
                response.getWriter().println(PageGenerator.generateAddLegalCustomerPage(legalCustomer));
            }
        } catch (NullRequiredFieldException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        } catch (InvalidEntranceException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
