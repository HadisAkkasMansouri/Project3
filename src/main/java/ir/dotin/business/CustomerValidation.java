package ir.dotin.business;

import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.InvalidEnteranceException;
import ir.dotin.exception.InvalidFormatException;
import ir.dotin.exception.NullRequiredFieldException;

public class CustomerValidation {


    public static boolean validateAddRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalId) throws NullRequiredFieldException, InvalidFormatException {

        if(name.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن فیلد نام اجباری است");
        }

        if(familyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام خانوادگی اجباری است");
        }

        if(fatherName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام پدر اجباری است");
        }

        if(birthDate.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن تاریخ تولد اجباری است");
        }

        if(nationalId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد ملی اجباری است");
        }

        if(nationalId.length() !=  10){
            throw new InvalidFormatException("فرمت کد ملی صحیح نمی باشد");
        }
        return true;
    }


    public static boolean validateAddLegalCustomer(String companeyName, String economicId, String registrationDate) throws NullRequiredFieldException, InvalidFormatException {
        if(companeyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام شرکت اجباری است");
        }

        if(economicId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد اقتصادی شرکت اجباری است");
        }

        if(registrationDate.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن تاریخ ثبت شرکت اجباری است");
        }

        if(((economicId.length()) < 10) || ((economicId.length()) > 10)){
            throw new InvalidFormatException("فرمت کد اقتصادی شرکت صحیح نمی باشد");
        }
        return true;
    }

    public static boolean validateDeleteRealCustomerId(String realCustomerId) throws InvalidEnteranceException{

        if (RealCustomerDAO.checkRealCustomerId(realCustomerId)){
            return true;
        }else{
            throw new InvalidEnteranceException("شماره مشتری وارد شده صحیح نمی باشد٬ لطفا مجددا تلاش کنید");
        }
    }

    public static boolean validateDeleteLegalCustomerId(String legalCustomerId) throws InvalidEnteranceException{

        if (LegalCustomerDAO.checkLegalCustomerId(legalCustomerId)){
            return true;
        }else{
            throw new InvalidEnteranceException("شماره مشتری وارد شده صحیح نمی باشد٬ لطفا مجددا تلاش کنید");
        }
    }

    public static boolean validateSearchRealCustomer(String name, String familyName, String realCustomerId, String nationalId) throws NullRequiredFieldException, InvalidFormatException {

        if(name.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن فیلد نام اجباری است");
        }

        if(familyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام خانوادگی اجباری است");
        }

        if(nationalId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد ملی اجباری است");
        }

        if(realCustomerId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن شماره مشتری حقیقی اجباری است");
        }

        if(nationalId.length() != 10){
            throw new InvalidFormatException("فرمت کد ملی صحیح نمی باشد");
        }
        return true;
    }

    public static boolean validateSearchLegalCustomer(String companeyName, String economicId, String legalCustomerId) throws NullRequiredFieldException, InvalidFormatException {
        if(companeyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام شرکت اجباری است");
        }

        if(economicId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد اقتصادی شرکت اجباری است");
        }

        if(legalCustomerId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن شماره مشتری حقوقی اجباری است");
        }

        if(economicId.length()!= 10){
            throw new InvalidFormatException("فرمت کد اقتصادی شرکت صحیح نمی باشد");
        }
        return true;
    }

    public static boolean validateNationalId(String nationalId) throws InvalidFormatException{

        if(nationalId.length() != 10){
            throw new InvalidFormatException("فرمت کد ملی صحیح نمی باشد");
        }
        return true;
    }

    public static boolean validateEconomiclId(String nationalId) throws InvalidFormatException{

        if(nationalId.length() != 10){
            throw new InvalidFormatException("فرمت کد اقتصادی شرکت صحیح نمی باشد");
        }
        return true;
    }
}
