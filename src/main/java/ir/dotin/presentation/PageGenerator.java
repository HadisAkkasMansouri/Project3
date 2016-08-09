package ir.dotin.presentation;

import ir.dotin.dataaccess.RealCustomer;

import java.util.List;

public class PageGenerator {

    public static String generateSearchOfLegalCustomerHTML(List<RealCustomer> realCustomers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        for (RealCustomer legalCustomer : realCustomers) {
            stringBuilder.append("                        <tr>");
            stringBuilder.append("                            <td>" + legalCustomer.getName() + "</td>");
            stringBuilder.append("                            <td>" + legalCustomer.getFamilyName() + "</td>");
            stringBuilder.append("                            <td>" + legalCustomer.getFatherName() + "</td>");
            stringBuilder.append("                            <td>" + legalCustomer.getBirthDate() + "</td>");
            stringBuilder.append("                            <td>" + legalCustomer.getNationalId() + "</td>");
            stringBuilder.append("                            <td>" + legalCustomer.getCustomerId() + "</td>");
            stringBuilder.append("                            <td><a href=/DeleteLegalCustomerServlet?id=" + legalCustomer.getCustomerId() + " class=form>حذف</a>");
            stringBuilder.append("                            <a href=/UpdateLegalCustomerServlet?id=" + legalCustomer.getCustomerId() + " class=form>اصلاح</a></td>");
        }
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <a href=htmlfile/search-legal-customer.html class=form>بازگشت به صفحه قبل</a>");
        stringBuilder.append("            </div>");
        stringBuilder.append("        </div>");
        stringBuilder.append("    </div>");
        stringBuilder.append("</div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
