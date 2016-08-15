package ir.dotin.presentation;

import ir.dotin.business.CustomerLegalValidation;
import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.InvalidEntranceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveChangesLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String companyName = request.getParameter("CompanyName");
        String economicCode = request.getParameter("EconomicCode");
        String registrationDate = request.getParameter("RegistrationDate");
        String customerNumber = request.getParameter("CustomerNumber");

        try {
            LegalCustomer legalCustomer = CustomerLegalValidation.validateUpdateLegalCustomer(companyName, economicCode, registrationDate, customerNumber);
            response.getWriter().println(PageGenerator.generateSaveChangesLegalCustomer(legalCustomer));
        } catch (InvalidEntranceException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        } catch (DuplicateEntranceException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        }
    }
}
