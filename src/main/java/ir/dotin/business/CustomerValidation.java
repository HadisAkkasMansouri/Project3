package ir.dotin.business;

import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NullRequiredFieldException;

public class CustomerValidation {


    public static boolean validateAddRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalId) throws NullRequiredFieldException, InvalidEntranceException {

        if(name.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن فیلد نام الزامی است");
        }

        if(familyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام خانوادگی الزامی است");
        }

        if(fatherName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام پدر الزامی است");
        }

        if(birthDate.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن تاریخ تولد الزامی است");
        }

        if(nationalId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد ملی الزامی است");
        }

        if(nationalId.length() !=  10){
            throw new InvalidEntranceException("کد ملی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
        }
        return true;
    }


    public static boolean validateAddLegalCustomer(String companeyName, String economicId, String registrationDate) throws NullRequiredFieldException, InvalidEntranceException {
        if(companeyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام شرکت الزامی است");
        }

        if(economicId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد اقتصادی شرکت الزامی است");
        }

        if(registrationDate.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن تاریخ ثبت شرکت الزامی است");
        }

        if(economicId.length() != 10){
            throw new InvalidEntranceException("کد اقتصادی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
        }
        return true;
    }

    public static boolean validateDeleteRealCustomerId(String realCustomerId) throws InvalidEntranceException {

        if (RealCustomerDAO.checkRealCustomerId(realCustomerId)){
            return true;
        }else{
            throw new InvalidEntranceException("شماره مشتری وارد شده صحیح نمی باشد٬ لطفا مجددا تلاش کنید");
        }
    }

    public static boolean validateDeleteLegalCustomerId(String legalCustomerId) throws InvalidEntranceException {

        if (LegalCustomerDAO.checkLegalCustomerId(legalCustomerId)){
            return true;
        }else{
            throw new InvalidEntranceException("شماره مشتری وارد شده صحیح نمی باشد٬ لطفا مجددا تلاش کنید");
        }
    }

    public static boolean validateSearchRealCustomer(String name, String familyName, String realCustomerId, String nationalId) throws NullRequiredFieldException, InvalidEntranceException {

        if(name.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن فیلد نام الزامی است");
        }

        if(familyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام خانوادگی الزامی است");
        }

        if(nationalId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد ملی الزامی است");
        }

        if(realCustomerId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن شماره مشتری حقیقی الزامی است");
        }

        if(nationalId.length() != 10){
            throw new InvalidEntranceException("کد ملی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
        }
        return true;
    }

    public static boolean validateSearchLegalCustomer(String companeyName, String economicId, String legalCustomerId) throws NullRequiredFieldException, InvalidEntranceException {
        if(companeyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام شرکت الزامی است");
        }

        if(economicId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد اقتصادی شرکت الزامی است");
        }

        if(legalCustomerId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن شماره مشتری حقوقی الزامی است");
        }

        if(economicId.length()!= 10){
            throw new InvalidEntranceException("کد اقتصادی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
        }
        return true;
    }
}
