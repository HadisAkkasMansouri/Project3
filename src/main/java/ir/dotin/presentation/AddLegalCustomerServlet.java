package ir.dotin.presentation;

import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.dataaccess.LegalCustomerDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddLegalCustomerServlet extends HttpServlet{

    LegalCustomer legalCustomer = new LegalCustomer();
    LegalCustomerDao dao = new LegalCustomerDao();

    protected void addLegalCustomerRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        legalCustomer.setCompanyName(request.getParameter("CompaneyName"));
        legalCustomer.setEconomicId(request.getParameter("EconomicId"));
        legalCustomer.setRegistrationDate(request.getParameter("RegistrationDate"));
        response.setContentType("text/html;charset=UTF-8");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        addLegalCustomerRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

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
        addLegalCustomerRequest(request, response);
    }
}
