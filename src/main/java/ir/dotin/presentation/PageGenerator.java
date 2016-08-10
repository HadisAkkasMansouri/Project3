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
        stringBuilder.append("<body style='background-color:#000000;'>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right\">نتایج جستجو</h1>");
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
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getCustomerId());
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getFamilyName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getFatherName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getBirthDate() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + realCustomer.getNationalId() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center\"><a href=/DeleteRealCustomerServlet?id=" + realCustomer.getCustomerId() + " class= form \"color: red\"> حذف </a></td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center\"><a href=/UpdateRealCustomerServlet?id=" + realCustomer.getCustomerId() + " class=form> اصلاح </a></td>");
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
        stringBuilder.append("<body style='background-color:#000000;'>");
        stringBuilder.append("    <link href=/htmlfile/cssfile/styleSheet.css rel=stylesheet>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("<h1 style = \"color:#fff8dc; align: right\">نتایج جستجو</h1>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > شماره مشتری");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > نام شرکت");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > تاریخ ثبت");
        stringBuilder.append("<th style = \"background: #b8860b ; color: black; font-weight: bold; text-align: center \" > کد اقتصادی");
        stringBuilder.append("</th>");
        for (LegalCustomer legalCustomer : legalCustomers) {
            stringBuilder.append("                        <tr>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + legalCustomer.getCustomerId());
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + legalCustomer.getCompanyName() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + legalCustomer.getRegistrationDate() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; text-align: center; color:black\">" + legalCustomer.getEconomicId() + "</td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center\"><a href=/DeleteLegalCustomerServlet?id=" + legalCustomer.getCustomerId() + " class= form \"color: red\"> حذف </a></td>");
            stringBuilder.append("<td style = \"background:#fff8dc; font-weight: bold; text-align: center\"><a href=/UpdateLegalCustomerServlet?id=" + legalCustomer.getCustomerId() + " class=form> اصلاح </a></td>");
        }
        stringBuilder.append("</table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
