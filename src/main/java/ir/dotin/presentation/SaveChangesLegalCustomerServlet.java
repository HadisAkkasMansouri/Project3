package ir.dotin.presentation;

import ir.dotin.dataaccess.LegalCustomerDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class SaveChangesLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String companyName = request.getParameter("CompanyName");
        String economicId = request.getParameter("EconomicId");
        String legalCustomerId = request.getParameter("LegalCustomerId");
        String registrationDate = request.getParameter("registrationDate");

        try {
            legalCustomerDAO.updateLegalCustomer(companyName, registrationDate, economicId, legalCustomerId);
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + "اطلاعات مشتری حقوقی با موفقیت ویرایش شد" + "</h1>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
