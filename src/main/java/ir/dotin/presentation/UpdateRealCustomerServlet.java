package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.InvalidEntranceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateRealCustomerServlet extends HttpServlet {

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

        if (!realCustomerID.isEmpty()) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + "شماره مشتری حقیقی قابل اصلاح نیست لطفا مجددا تلاش کنید" + "</h1>");
        }else {

        }
    }
}