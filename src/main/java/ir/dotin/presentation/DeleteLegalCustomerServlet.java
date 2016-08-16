package ir.dotin.presentation;

import ir.dotin.business.CustomerLegalValidation;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();

        int id = Integer.valueOf(request.getParameter("ID"));

        CustomerLegalValidation.deleteLegalCustomer(id);
        result.println("<!DOCTYPE html>");
        result.println("<html><head>");
        result.println("<content='text/html; charset=UTF-8'>");
        result.println("<title>generatedLegalCustomer</title></head>");
        result.println("<body style='background-color:#000000; direction:rtl;'>");
        result.println("<h1 style = \"color:#fff8dc\"'>اطلاعات مشتری حقوقی وارد شده با موفقیت حذف شد</h1>");
        result.println("</font></body>");
        result.println("</html>");

//        } catch (InvalidEntranceException e) {
//            result.println("<body style='background-color:#000000; direction:rtl;'>");
//            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
//            e.printStackTrace();
//        }
    }
}
