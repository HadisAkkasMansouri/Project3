package ir.dotin.presentation;

import ir.dotin.business.CustomerRealValidation;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.InvalidEntranceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveChangesRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("Name");
        String fatherName = request.getParameter("FatherName");
        String familyName = request.getParameter("FamilyName");
        String birthDate = request.getParameter("BirthDate");
        String nationalCode = request.getParameter("NationalCode");
        String customerNumber = request.getParameter("CustomerNumber");
        try {
            CustomerRealValidation.validateUpdateRealCustomer(name, familyName, fatherName, birthDate, nationalCode, customerNumber);
            response.getWriter().println(PageGenerator.generateresultPage("اطلاعات مشتری حقیقی با موفقیت ویرایش شد"));
        } catch (InvalidEntranceException e) {
            response.getWriter().println(PageGenerator.generateresultPage(e.getMessage()));
            e.printStackTrace();
        } catch (DuplicateEntranceException e) {
            response.getWriter().println(PageGenerator.generateresultPage(e.getMessage()));
            e.printStackTrace();
        }
    }
}
