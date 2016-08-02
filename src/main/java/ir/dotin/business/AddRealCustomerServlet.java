package ir.dotin.business;

import ir.dotin.dataAccess.RealCustomerDao;
import ir.dotin.entities.RealCustomer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddRealCustomerServlet extends HttpServlet {


    RealCustomer realCustomer = new RealCustomer();
    RealCustomerDao dao = new RealCustomerDao();

    protected void addRealCustomerRequest(HttpServletRequest request, HttpServletResponse response){

        realCustomer.setName(request.getParameter("NAME"));
        realCustomer.setFamilyName(request.getParameter("FAMILY_NAME"));
        realCustomer.setFatherName(request.getParameter("FATHER_NAME"));
        realCustomer.setBirthDate(request.getParameter("BIRTH_DATE"));
        realCustomer.setNationalId(request.getParameter("NATIONAL_ID"));

//        boolean result = dao.addRealCustomer(realCustomer);
//        if (result){
//            response.sendRedirect();
//        }else {
//            response.sendRedirect();
//        }
    }

    protected void sendResoponse(HttpServletRequest request, HttpServletResponse response){
        addRealCustomerRequest(request, response);
    }

    protected void receiveRequest(HttpServletRequest request, HttpServletResponse response){
        addRealCustomerRequest(request, response);
    }
}
