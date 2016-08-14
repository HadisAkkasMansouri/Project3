package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.exception.DuplicateEntranceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveChangesLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String companyName = request.getParameter("CompanyName");
        String economicId = request.getParameter("EconomicId");
        String registrationDate = request.getParameter("RegistrationDate");
        String customerNumber = request.getParameter("CustomerNumber");

        try {
            if(CustomerValidation.validateDuplicateEconomicId(economicId, customerNumber)) {
                if(legalCustomerDAO.updateLegalCustomer(companyName, registrationDate, economicId, customerNumber)) {
                    result.println("<body style='background-color:#000000; direction:rtl;'>");
                    result.println("<h1 style = \"color:#fff8dc\"'>" + "اطلاعات مشتری حقوقی با موفقیت ویرایش شد" + "</h1>");
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
}
