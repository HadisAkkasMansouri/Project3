package ir.dotin.presentation;

import ir.dotin.dataaccess.LegalCustomerDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteLegalCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        addLegalCustomerRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String legalCustomerId = request.getParameter("LegalCustomerId");
        if (legalCustomerDAO.checkLegalCustomerId(legalCustomerId)) {
            legalCustomerDAO.deleteLegalCustomer(legalCustomerId);
            result.println("<!DOCTYPE html>");
            result.println("<html><head>");
            result.println("<content='text/html; charset=UTF-8'>");
            result.println("<title>generatedLegalCustomer</title></head>");
            result.println("<body style='background-color:#000000;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>اطلاعات مشتری حقوقی وارد شده با موفقیت حذف شد</h1>");
            result.println("</font></body>");
            result.println("</html>");
        }
        else {
            result.println("<!DOCTYPE html>");
            result.println("<html><head>");
            result.println("<content='text/html; charset=UTF-8'>");
            result.println("<title>generatedLegalCustomer</title></head>");
            result.println("<body style='background-color:#000000;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>شماره مشتری حقوقی وارد شده صحیح نمی باشد لطفا مجددا تلاش کنید</h1>");
            result.println("</font></body>");
            result.println("</html>");
        }
    }
}
