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
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; color: red\"><a href=/DeleteRealCustomerServlet?id=" + realCustomer.getCustomerNumber() + " class= form > حذف </a></td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; color: red\"><a href=/UpdateRealCustomerServlet?id=" + realCustomer.getCustomerNumber() + " class=form> اصلاح </a></td>");
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
        stringBuilder.append("                <br>");
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
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; color: red \"><a href=/DeleteLegalCustomerServlet?id=" + legalCustomer.getCustomerNumber() + " class= form > حذف </a></td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center; color: red\"><a href=/UpdateLegalCustomerServlet?id=" + legalCustomer.getCustomerNumber() + " class=form> اصلاح </a></td>");
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
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right\">مشتری حقیقی با موفقیت به شرح زیر٬ ذخیره شد :</h1>");
        stringBuilder.append("                <br>");
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
        stringBuilder.append("<body style='background-color:#000000;  direction:rtl;'>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right\">مشتری حقوقی با موفقیت به شرح زیر٬ ذخیره شد :</h1>");
        stringBuilder.append("                <br>");
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
}
