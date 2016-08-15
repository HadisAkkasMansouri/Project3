package ir.dotin.presentation;

import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.dataaccess.LegalCustomerDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("ID"));

        LegalCustomer legalCustomer = null;
        try {
            legalCustomer = legalCustomerDAO.GetLegalCustomer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().println(PageGenerator.generateUpdateLegalCustomer(legalCustomer));
    }
}