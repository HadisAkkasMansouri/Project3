package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.dataaccess.RealCustomer;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.InvalidEntranceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UpdateRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String name = request.getParameter("Name");
        String familyName = request.getParameter("FamilyName");
        String realCustomerId = request.getParameter("RealCustomerNumber");
        String nationalId = request.getParameter("NationalId");

        RealCustomer realCustomer = null;
        try {
            realCustomer = RealCustomerDAO.GetRealCustomer(realCustomerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().println(PageGenerator.generateUpdateRealCustomer(realCustomer));


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}