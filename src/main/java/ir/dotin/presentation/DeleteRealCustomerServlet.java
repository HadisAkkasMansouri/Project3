package ir.dotin.presentation;

import ir.dotin.business.CustomerRealValidation;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String realCustomerNumber = request.getParameter("RealCustomerNumber");
        int id = Integer.parseInt(request.getParameter("ID"));

        CustomerRealValidation.deleteRealCustomer(id);
        response.getWriter().println(PageGenerator.generateresultPage("اطلاعات مشتری حقیقی وارد شده با موفقیت حذف شد"));
    }
}
