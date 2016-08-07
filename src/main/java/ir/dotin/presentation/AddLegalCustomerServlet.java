package ir.dotin.presentation;

import ir.dotin.exception.InvalidFormatException;
import ir.dotin.exception.NullRequiredFieldException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddLegalCustomerServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        addLegalCustomerRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter result = response.getWriter();
        result.println("<!DOCTYPE html>");
        result.println("<html><head>");
        result.println("<content='text/html; charset=UTF-8'>");
        result.println("<title>generatedLegalCustomer</title></head>");
        result.println("<body>");
        result.println("<h1>اطلاعات مشتری حقوقی با موفقیت ‌ذخیره شد</h1>");
        String companeyName = request.getParameter("CompaneyName");
        String economicId = request.getParameter("EconomicId");
        String registrationDate = request.getParameter("RegistrationDate");
        result.println(companeyName);
        result.println(economicId);
        result.println(registrationDate);
        try {
            CustomerValidation.validateLegalCustomer(companeyName, economicId, registrationDate);
        } catch (NullRequiredFieldException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
