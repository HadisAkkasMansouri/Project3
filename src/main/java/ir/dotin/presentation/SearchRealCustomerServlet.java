package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.RealCustomer;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.InvalidFormatException;
import ir.dotin.exception.NullRequiredFieldException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String name = request.getParameter("Name");
        String familyName = request.getParameter("FamilyName");
        String realCustomerID = request.getParameter("RealCustomerId");
        String nationalId = request.getParameter("NationalId");
        try {
            if(/*CustomerValidation.validateNationalId(nationalId) && */(nationalId.isEmpty())){
                List<RealCustomer> realCustomers = realCustomerDAO.searchRealCustomer(name, familyName, nationalId, realCustomerID);
                response.getWriter().println(PageGenerator.generateSearchOfRealCustomerHTML(realCustomers));

            }else if (CustomerValidation.validateNationalId(nationalId)){
                List<RealCustomer> realCustomers = realCustomerDAO.searchRealCustomer(name, familyName, nationalId, realCustomerID);
                response.getWriter().println(PageGenerator.generateSearchOfRealCustomerHTML(realCustomers));
            }
        } catch (InvalidFormatException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        }
    }

}

