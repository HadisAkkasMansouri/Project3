package ir.dotin.presentation;

import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.dataaccess.RealCustomer;

import java.util.List;

public class PageGenerator {

    public static String generateSearchOfRealCustomerHTML(List<RealCustomer> realCustomers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("<body style='background-color:#000000; direction:rtl;'>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right\">نتایج جستجو به شرح زیر است :</h1>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > شماره مشتری");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام خانوادگی");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام پدر");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > تاریخ تولد");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > کد ملی");
        stringBuilder.append("</th>");
        for (RealCustomer realCustomer : realCustomers) {
            stringBuilder.append("                        <tr>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getCustomerNumber());
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getFamilyName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getFatherName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getBirthDate() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getNationalId() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; color: red\"><a href=/DeleteRealCustomerServlet?RealCustomerId=" + realCustomer.getCustomerNumber() + " class= form > حذف </a></td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; color: red\"><a href=/UpdateRealCustomerServlet?RealCustomerId=" + realCustomer.getCustomerNumber() + " class=form> اصلاح </a></td>");
        }
        stringBuilder.append("</table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String generateSearchOfLegalCustomerHTML(List<LegalCustomer> legalCustomers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("<body style='background-color:#000000; direction:rtl;'>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right\">نتایج جستجو به شرح زیر است :</h1>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                    <table class=\"result-table; border=1\">");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > شماره مشتری");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام شرکت");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > تاریخ ثبت");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > کد اقتصادی");
        stringBuilder.append("</th>");
        for (LegalCustomer legalCustomer : legalCustomers) {
            stringBuilder.append("                        <tr>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black \">" + legalCustomer.getCustomerNumber());
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black \">" + legalCustomer.getCompanyName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black \">" + legalCustomer.getRegistrationDate() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black \">" + legalCustomer.getEconomicId() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; color: red \"><a href=/DeleteLegalCustomerServlet?LegalCustomerId=" + legalCustomer.getCustomerNumber() + " class= form > حذف </a></td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; color: red\"><a href=/UpdateLegalCustomerServlet?LegalCustomerId=" + legalCustomer.getCustomerNumber() + " class=form> اصلاح </a></td>");
        }
        stringBuilder.append("</table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String generateAddOfRealCustomerHTML(RealCustomer realCustomer){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl;'>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right\">مشتری حقیقی به شرح زیر با موفقیت٬ ذخیره شد :</h1>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > شماره مشتری </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getCustomerNumber() + "</td>");
        stringBuilder.append("                     </tr>");stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getName() + "</td>");
        stringBuilder.append("                     </tr>");stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام خانوادگی </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getFamilyName() + "</td>");
        stringBuilder.append("                     </tr>");stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام پدر </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getFatherName() + "</td>");
        stringBuilder.append("                     </tr>");stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > تاریخ تولد </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getBirthDate() + "</td>");
        stringBuilder.append("                     </tr>");stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > کد ملی </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getNationalId() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("</th>");
        stringBuilder.append("</table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String generateAddOfLegalCustomerHTML(LegalCustomer legalCustomer){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl;'>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right\">مشتری حقوقی به شرح زیر با موفقیت٬ ذخیره شد :</h1>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > شماره مشتری </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + legalCustomer.getCustomerNumber() + "</td>");
        stringBuilder.append("                     </tr>");

        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام شرکت </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + legalCustomer.getCompanyName() + "</td>");
        stringBuilder.append("                     </tr>");

        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > تاریخ ثبت </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + legalCustomer.getRegistrationDate() + "</td>");
        stringBuilder.append("                     </tr>");

        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > کد اقتصادی </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black\">" + legalCustomer.getEconomicId() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("</table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String generateUpdateLegalCustomer(LegalCustomer legalCustomer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl;>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                  <h1 style = \"color:#fff8dc; align: right\">ویرایش اطلاعات مشتری حقوقی :</h1>");
        stringBuilder.append("                 <form action='/SaveChangesLegalCustomerServlet' method='post'>");
        stringBuilder.append("                      </br>");
        stringBuilder.append("                      <input type='hidden' name='id' value='" + legalCustomer.getId() + "'>");
        stringBuilder.append("                      <table>");
        stringBuilder.append("                          <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" >شماره مشتری</td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='CustomerNumber' value='" + legalCustomer.getCustomerNumber() + "' readonly ></td>");
        stringBuilder.append("                          </tr>");
        stringBuilder.append("                          <tr>");
        stringBuilder.append("                              <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام شرکت </td>");
        stringBuilder.append("                              <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='CompanyName' value='" + legalCustomer.getCompanyName() + "'></td>");
        stringBuilder.append("                          </tr>");
        stringBuilder.append("                          <tr>");
        stringBuilder.append("                              <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > تاریخ ثبت</td>");
        stringBuilder.append("                              <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='RegistrationDate' value='" + legalCustomer.getRegistrationDate() + "'></td>");
        stringBuilder.append("                          </tr>");
        stringBuilder.append("                          <tr>");
        stringBuilder.append("                              <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" >کد اقتصادی</td>");
        stringBuilder.append("                              <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='EconomicId' value='" + legalCustomer.getEconomicId() + "'></td>");
        stringBuilder.append("                          </tr>");
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <input style = \"font-weight: bold\" type='submit' class='button' value='ثبت اطاعات جدید'>");
        stringBuilder.append("               </form>");
        stringBuilder.append("            </div>");
        stringBuilder.append("        </div>");
        stringBuilder.append("    </div>");
        stringBuilder.append("</div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

    public static String generateUpdateRealCustomer(RealCustomer realCustomer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl;>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right\">ویرایش اطلاعات مشتری حقیقی :</h1>");
        stringBuilder.append("                 <form action='/SaveChangesRealCustomerServlet'>");
        stringBuilder.append("                </br>");
        stringBuilder.append("<input type='hidden' name='id' value='" + realCustomer.getId() + "'>");
        stringBuilder.append("                    <table>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" >شماره مشتری</td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='CustomerNumber' value='" + realCustomer.getCustomerNumber() + "' readonly ></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام  </td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='Name' value='" + realCustomer.getName() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام خانوادگی </td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='FamilyName' value='" + realCustomer.getFamilyName() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام پدر </td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='FatherName' value='" + realCustomer.getFatherName() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > تاریخ تولد</td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='BirthDate' value='" + realCustomer.getBirthDate() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" >کد ملی</td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black\" type='text' name='NationalId' value='" + realCustomer.getNationalId() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <input style = \"font-weight: bold\" type='submit' class='button' value='ثبت اطاعات جدید'>");
        stringBuilder.append("                    </form>");
        stringBuilder.append("            </div>");
        stringBuilder.append("        </div>");
        stringBuilder.append("    </div>");
        stringBuilder.append("</div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }
}
