package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.exception.InvalidFormatException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchLegalCustomerServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String companyName = request.getParameter("CompaneyName");
        String economicId = request.getParameter("EconomicId");
        String legalCustomerId = request.getParameter("LegalCustomerId");
        try {
            if(/*CustomerValidation.validateEconomiclId(legalCustomerId) &&*/ economicId.isEmpty()){
                List<LegalCustomer> legalCustomers = legalCustomerDAO.searchLegalCustomer(companyName, economicId, legalCustomerId);
                response.getWriter().println(PageGenerator.generateSearchOfLegalCustomerHTML(legalCustomers));

            }else if(CustomerValidation.validateEconomiclId(economicId)){
                List<LegalCustomer> legalCustomers = legalCustomerDAO.searchLegalCustomer(companyName, economicId, legalCustomerId);
                response.getWriter().println(PageGenerator.generateSearchOfLegalCustomerHTML(legalCustomers));
            }
        } catch (InvalidFormatException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        }

    }
}
