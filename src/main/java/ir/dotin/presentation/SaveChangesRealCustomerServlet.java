package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.DuplicateEntranceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class SaveChangesRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String name = request.getParameter("Name");
        String fatherName = request.getParameter("FatherName");
        String familyName = request.getParameter("FamilyName");
        String realCustomerId = request.getParameter("CustomerNumber");
        String birthDate = request.getParameter("BirthDate");
        String nationalId = request.getParameter("NationalId");

        try {
            if(CustomerValidation.validateDuplicateNationalId(nationalId, realCustomerId)) {
                if(realCustomerDAO.updateRealCustomer(name, familyName, fatherName, birthDate, nationalId,realCustomerId)) {
                    result.println("<body style='background-color:#000000; direction:rtl;'>");
                    result.println("<h1 style = \"color:#fff8dc\"'>" + "اطلاعات مشتری حقیقی با موفقیت ویرایش شد" + "</h1>");
                } else {
                    result.println("<body style='background-color:#000000; direction:rtl;'>");
                    result.println("<h1 style = \"color:#fff8dc\"'>" + "خطا ارتباطی٬ لطفا مجددا تلاش نمایید" + "</h1>");
                }
            }
        } catch (DuplicateEntranceException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
