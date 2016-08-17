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
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right; font-family: B Nazanin\">نتایج جستجو به شرح زیر است :</h1>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > شماره مشتری");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام خانوادگی");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام پدر");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > تاریخ تولد");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > کد ملی");
        stringBuilder.append("</th>");
        for (RealCustomer realCustomer : realCustomers) {
            stringBuilder.append("                        <tr>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + realCustomer.getCustomerNumber());
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + realCustomer.getName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + realCustomer.getFamilyName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + realCustomer.getFatherName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + realCustomer.getBirthDate() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + realCustomer.getNationalCode() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; font-family: B Nazanin\"><a href=/DeleteRealCustomerServlet?ID=" + realCustomer.getId() + " class= form > حذف </a></td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; font-family: B Nazanin\"><a href=/UpdateRealCustomerServlet?ID=" + realCustomer.getId() + " class=form> اصلاح </a></td>");
        }
        stringBuilder.append("</table>");
        stringBuilder.append("<div class=style></br></br></br></br></br></br></br></br></br></br></br></br></br></br>");
        stringBuilder.append("<button onclick=\"goBack()\" style='float:left; margin-left:95px;' >صفحه قبل >></button>");
        stringBuilder.append("</div>");
        stringBuilder.append("<script>");
        stringBuilder.append("function goBack() {");
        stringBuilder.append("window.history.back();}");
        stringBuilder.append("</script>");
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
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right; font-family: B Nazanin\">نتایج جستجو به شرح زیر است :</h1>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                    <table class=\"result-table; border=1\">");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > شماره مشتری");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام شرکت");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > تاریخ ثبت");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > کد اقتصادی");
        stringBuilder.append("</th>");
        for (LegalCustomer legalCustomer : legalCustomers) {
            stringBuilder.append("                        <tr>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + legalCustomer.getCustomerNumber());
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + legalCustomer.getCompanyName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + legalCustomer.getRegistrationDate() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + legalCustomer.getEconomicCode() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; font-family: B Nazanin \"><a href=/DeleteLegalCustomerServlet?ID=" + legalCustomer.getId() + " class= form > حذف </a></td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; font-family: B Nazanin\"><a href=/UpdateLegalCustomerServlet?ID=" + legalCustomer.getId() + " class=form> اصلاح </a></td>");
        }
        stringBuilder.append("</table>");
        stringBuilder.append("<div class=style></br></br></br></br></br></br></br></br></br></br></br></br></br></br>");
        stringBuilder.append("<button onclick=\"goBack()\" style='float:left; margin-left:95px;' >صفحه قبل >></button>");
        stringBuilder.append("</div>");
        stringBuilder.append("<script>");
        stringBuilder.append("function goBack() {");
        stringBuilder.append("window.history.back();}");
        stringBuilder.append("</script>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String generateAddRealCustomerPage(RealCustomer realCustomer){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl;'>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right; font-family: B Nazanin\">مشتری حقیقی به شرح زیر با موفقیت٬ ذخیره شد :</h1>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > شماره مشتری </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getCustomerNumber() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getName() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام خانوادگی </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getFamilyName() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام پدر </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getFatherName() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > تاریخ تولد </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getBirthDate() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > کد ملی </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getNationalCode() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("</th>");
        stringBuilder.append("</table>");
        stringBuilder.append("</body>");
        stringBuilder.append("<div class=style>");
        stringBuilder.append("<div class=style></br></br></br></br></br></br></br></br></br></br></br></br></br></br>");
        stringBuilder.append("<button onclick=\"goBack()\" style='float:left; margin-left:95px;' >صفحه قبل >></button>");
        stringBuilder.append("<script>");
        stringBuilder.append("function goBack() {");
        stringBuilder.append("window.history.back();}");
        stringBuilder.append("</script>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String generateAddLegalCustomerPage(LegalCustomer legalCustomer){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl;'>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right; font-family: B Nazanin\">مشتری حقوقی به شرح زیر با موفقیت٬ ذخیره شد :</h1>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > شماره مشتری </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + legalCustomer.getCustomerNumber() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام شرکت </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + legalCustomer.getCompanyName() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > تاریخ ثبت </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + legalCustomer.getRegistrationDate() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > کد اقتصادی </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + legalCustomer.getEconomicCode() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("</table>");
        stringBuilder.append("<div class=style></br></br></br></br></br></br></br></br></br></br></br></br></br></br>");
        stringBuilder.append("<button onclick=\"goBack()\" style='float:left; margin-left:95px;' >صفحه قبل >></button>");
        stringBuilder.append("</div>");
        stringBuilder.append("<script>");
        stringBuilder.append("function goBack() {");
        stringBuilder.append("window.history.back();}");
        stringBuilder.append("</script>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String generateUpdateLegalCustomer(LegalCustomer legalCustomer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang='fa'>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body style='background-color:#000000;direction:rtl;'>");
        stringBuilder.append("<div id='wrapper'>");
        stringBuilder.append("    <div class='content'>");
        stringBuilder.append("        <div class='box'>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                  <h1 style = \"color:#fff8dc; align: right; font-family: B Nazanin\">ویرایش اطلاعات مشتری حقوقی :</h1>");
        stringBuilder.append("                 <form action='/SaveChangesLegalCustomerServlet' method='get'>");
        stringBuilder.append("                      </br>");
        stringBuilder.append("                      <input type='hidden' name='id' value='" + legalCustomer.getId() + "'>");
        stringBuilder.append("                      <table>");
        stringBuilder.append("                          <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" >شماره مشتری</td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\" type='text' name='CustomerNumber' value='" + legalCustomer.getCustomerNumber() + "' readonly ></td>");
        stringBuilder.append("                          </tr>");
        stringBuilder.append("                          <tr>");
        stringBuilder.append("                              <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام شرکت </td>");
        stringBuilder.append("                              <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\" type='text' name='CompanyName' value='" + legalCustomer.getCompanyName() + "'></td>");
        stringBuilder.append("                          </tr>");
        stringBuilder.append("                          <tr>");
        stringBuilder.append("                              <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > تاریخ ثبت</td>");
        stringBuilder.append("                              <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\" type='text' name='RegistrationDate' value='" + legalCustomer.getRegistrationDate() + "'></td>");
        stringBuilder.append("                          </tr>");
        stringBuilder.append("                          <tr>");
        stringBuilder.append("                              <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" >کد اقتصادی</td>");
        stringBuilder.append("                              <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\" type='text' name='EconomicCode' value='" + legalCustomer.getEconomicCode() + "'></td>");
        stringBuilder.append("                          </tr>");
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <input style = \"font-weight: bold; font-family: B Nazanin\" type='submit' class='button' value='ثبت اطاعات جدید'>");
        stringBuilder.append("               </form>");
        stringBuilder.append("            </div>");
        stringBuilder.append("        </div>");
        stringBuilder.append("    </div>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div class=style></br></br></br></br></br></br></br></br></br></br></br></br></br></br>");
        stringBuilder.append("<button onclick=\"goBack()\" style='float:left; margin-left:95px;' >صفحه قبل >></button>");
        stringBuilder.append("</div>");
        stringBuilder.append("<script>");
        stringBuilder.append("function goBack() {");
        stringBuilder.append("window.history.back();}");
        stringBuilder.append("</script>");
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
        stringBuilder.append("</head>");
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl';>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div id='wrapper'>");
        stringBuilder.append("    <div class='content'>");
        stringBuilder.append("        <div class='box'>");
        stringBuilder.append("            <div class='box-in'>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right; font-family: B Nazanin\">ویرایش اطلاعات مشتری حقیقی :</h1>");
        stringBuilder.append("                 <form action='/SaveChangesRealCustomerServlet'>");
        stringBuilder.append("                </br>");
        stringBuilder.append("<input type='hidden' name='id' value='" + realCustomer.getId() + "'>");
        stringBuilder.append("                    <table>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" >شماره مشتری</td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \" type='text' name='CustomerNumber' value='" + realCustomer.getCustomerNumber() + "' readonly ></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام  </td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \" type='text' name='Name' value='" + realCustomer.getName() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام خانوادگی </td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \" type='text' name='FamilyName' value='" + realCustomer.getFamilyName() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام پدر </td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \" type='text' name='FatherName' value='" + realCustomer.getFatherName() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > تاریخ تولد</td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \" type='text' name='BirthDate' value='" + realCustomer.getBirthDate() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" >کد ملی</td>");
        stringBuilder.append("                            <td><input style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \" type='text' name='NationalCode' value='" + realCustomer.getNationalCode() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <input style = \"font-weight: bold; font-family: B Nazanin\" type='submit' class='button' value='ثبت اطاعات جدید'>");
        stringBuilder.append("                    </form>");
        stringBuilder.append("            </div>");
        stringBuilder.append("        </div>");
        stringBuilder.append("    </div>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div class=style></br></br></br></br></br></br></br></br></br></br></br></br></br></br>");
        stringBuilder.append("<button onclick=\"goBack()\" style='float:left; margin-left:95px;' >صفحه قبل >></button>");
        stringBuilder.append("</div>");
        stringBuilder.append("<script>");
        stringBuilder.append("function goBack() {");
        stringBuilder.append("window.history.back();}");
        stringBuilder.append("</script>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

    public static String generateSaveChangesLegalCustomer(LegalCustomer legalCustomer){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl;'>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right; font-family: B Nazanin\">اطلاعات مشتری حقوقی به شرح زیر با موفقیت٬ ویرایش شد :</h1>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > شماره مشتری </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + legalCustomer.getCustomerNumber() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام شرکت </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + legalCustomer.getCompanyName() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > تاریخ ثبت </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + legalCustomer.getRegistrationDate() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > کد اقتصادی </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin\">" + legalCustomer.getEconomicCode() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("</table>");
        stringBuilder.append("<div class=style></br></br></br></br></br></br></br></br></br></br></br></br></br></br>");
        stringBuilder.append("<button onclick=\"goBack()\" style='float:left; margin-left:95px;' >صفحه قبل >></button>");
        stringBuilder.append("</div>");
        stringBuilder.append("<script>");
        stringBuilder.append("function goBack() {");
        stringBuilder.append("window.history.back();}");
        stringBuilder.append("</script>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();

    }

    public static String generateSaveChangesRealCustomer(RealCustomer realCustomer){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl;'>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right; font-family: B Nazanin \">اطلاعات مشتری حقیقی به شرح زیر با موفقیت٬ ویرایش شد :</h1>");
        stringBuilder.append("                </br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("                    <tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > شماره مشتری </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getCustomerNumber() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getName() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام خانوادگی </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getFamilyName() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > نام پدر </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getFatherName() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > تاریخ تولد </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getBirthDate() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("                          <td style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center; font-family: B Nazanin \" > کد ملی </td>");
        stringBuilder.append("                          <td style = \"background:#fff8dc; text-align: center; color:black; font-family: B Nazanin \">" + realCustomer.getNationalCode() + "</td>");
        stringBuilder.append("                     </tr>");
        stringBuilder.append("</th>");
        stringBuilder.append("</table>");
        stringBuilder.append("<div class=style></br></br></br></br></br></br></br></br></br></br></br></br></br></br>");
        stringBuilder.append("<button onclick=\"goBack()\" style='float:left; margin-left:95px;' >صفحه قبل >></button>");
        stringBuilder.append("</div>");
        stringBuilder.append("<script>");
        stringBuilder.append("function goBack() {");
        stringBuilder.append("window.history.back();}");
        stringBuilder.append("</script>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String generateresultPage(String message){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("<body style='background-color:#000000; direction:rtl;'>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: center; font-family: B Nazanin \"'>" + message + "</h1>");
        stringBuilder.append("<div class=style></br></br></br></br></br></br></br></br></br></br></br></br></br></br>");
        stringBuilder.append("<button onclick=\"goBack()\" style='float:left; margin-left:95px;' >صفحه قبل >></button>");
        stringBuilder.append("</div>");
        stringBuilder.append("<script>");
        stringBuilder.append("function goBack() {");
        stringBuilder.append("window.history.back();}");
        stringBuilder.append("</script>");
        stringBuilder.append("</body>");
        return stringBuilder.toString();

    }

}