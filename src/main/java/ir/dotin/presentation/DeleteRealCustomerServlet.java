package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.RealCustomer;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.InvalidEnteranceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.ValidationMessage;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteRealCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        addRealCustomerRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        RealCustomer realCustomer = new RealCustomer();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
//        String realCustomerId = request.getParameter("RealCustomerId");
        String realCustomerId = realCustomer.getCustomerNumber();

        try {
            if (CustomerValidation.validateDeleteRealCustomerId(realCustomerId)) {
                realCustomerDAO.deleteRealCustomer(realCustomer);
                result.println("<!DOCTYPE html>");
                result.println("<html><head>");
                result.println("<content='text/html; charset=UTF-8'>");
                result.println("<title>generatedRealCustomer</title></head>");
                result.println("<body style='background-color:#000000; direction:rtl;'>");
                result.println("<h1 style = \"color:#fff8dc\"'>اطلاعات مشتری حقیقی وارد شده با موفقیت حذف شد</h1>");
                result.println("</font></body>");
                result.println("</html>");
            }
        } catch (InvalidEnteranceException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        }
    }
}
