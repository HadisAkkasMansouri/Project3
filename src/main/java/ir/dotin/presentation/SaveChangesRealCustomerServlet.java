package ir.dotin.presentation;

import ir.dotin.business.CustomerRealValidation;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.InvalidEntranceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveChangesRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String name = request.getParameter("Name");
        String fatherName = request.getParameter("FatherName");
        String familyName = request.getParameter("FamilyName");
        String birthDate = request.getParameter("BirthDate");
        String nationalCode = request.getParameter("NationalCode");
        String customerNumber = request.getParameter("CustomerNumber");
        try {
            CustomerRealValidation.validateUpdateRealCustomer(name, familyName, fatherName, birthDate, nationalCode, customerNumber);
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + "اطلاعات مشتری حقیقی با موفقیت ویرایش شد" + "</h1>");
        } catch (InvalidEntranceException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        } catch (DuplicateEntranceException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        }
    }
}
