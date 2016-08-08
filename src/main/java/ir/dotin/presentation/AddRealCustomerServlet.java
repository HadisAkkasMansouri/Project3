package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.InvalidFormatException;
import ir.dotin.exception.NullRequiredFieldException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddRealCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        addRealCustomerRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String name = request.getParameter("Name");
        String familyName = new String(request.getParameter("FamilyName").getBytes(),"UTF-8");
        String fatherName = new String(request.getParameter("FatherName").getBytes(),"UTF-8");
        String birthDate = new String(request.getParameter("BirthDate").getBytes(),"UTF-8");
        String nationalId = new String(request.getParameter("NationalId").getBytes(),"UTF-8");
        try {
            if(CustomerValidation.validateRealCustomer(name, familyName, fatherName, birthDate, nationalId)){

                result.println("<!DOCTYPE html>");
                result.println("<html><head>");
                result.println("<content='text/html; charset=UTF-8'>");
                result.println("<title>generatedLegalCustomer</title></head>");
                result.println("<body>");
                result.println("\"<h1 style = \"color:#fff8dc\"'>اطلاعات مشتری حقیقی با موفقیت ‌ذخیره شد</h1>");
                result.println("<font color='#fff8dc'>" + name);
                result.println(familyName);
                result.println(fatherName);
                result.println(birthDate);
                result.println(nationalId);
                result.println("</font></body>");
                result.println("</html>");
            }
        } catch (NullRequiredFieldException e) {
            result.println(e.getMessage());
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            result.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
