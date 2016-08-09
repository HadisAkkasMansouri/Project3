package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.exception.InvalidFormatException;
import ir.dotin.exception.NullRequiredFieldException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddLegalCustomerServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        addLegalCustomerRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String companyName = request.getParameter("CompaneyName");
        String economicId = request.getParameter("EconomicId");
        String registrationDate = request.getParameter("RegistrationDate");
        try {
            if (CustomerValidation.validateAddLegalCustomer(companyName, economicId, registrationDate)) {
                legalCustomerDAO.addLegalCustomer(companyName, economicId, registrationDate);
                result.println("<!DOCTYPE html>");
                result.println("<html><head>");
                result.println("<content='text/html; charset=UTF-8'>");
                result.println("<title>generatedLegalCustomer</title></head>");
                result.println("<body style='background-color:#000000;'>");
                result.println("<h1 style = \"color:#fff8dc\"'>اطلاعات مشتری حقوقی با موفقیت ‌ذخیره شد</h1>");
                result.println("<font color='#fff8dc'>" + companyName);
                result.println(economicId);
                result.println(registrationDate);
                result.println("</font></body>");
                result.println("</html>");
            }
        } catch (NullRequiredFieldException e) {
            result.println("<body style='background-color:#000000;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            result.println("<body style='background-color:#000000;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        }
    }
}
