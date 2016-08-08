package ir.dotin.presentation;

import ir.dotin.dataaccess.RealCustomerDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteRealCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        addRealCustomerRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String realCustomerId = request.getParameter("RealCustomerId");
        if (realCustomerDAO.checkRealCustomerId(realCustomerId)) {
            realCustomerDAO.deleteRealCustomer(realCustomerId);
            result.println("<!DOCTYPE html>");
            result.println("<html><head>");
            result.println("<content='text/html; charset=UTF-8'>");
            result.println("<title>generatedRealCustomer</title></head>");
            result.println("<body style='background-color:#000000;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>اطلاعات مشتری حقیقی وارد شده با موفقیت حذف شد</h1>");
            result.println("</font></body>");
            result.println("</html>");
        }
    }
}
