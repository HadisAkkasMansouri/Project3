package ir.dotin.business;

import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.InvalidEnteranceException;
import ir.dotin.exception.InvalidFormatException;
import ir.dotin.exception.NullRequiredFieldException;

public class CustomerValidation {

    LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
    RealCustomerDAO realCustomerDAO = new RealCustomerDAO();

    public static boolean validateRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalId) throws NullRequiredFieldException, InvalidFormatException {

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

        if(nationalId.length() < 10 || nationalId.length() > 10){
            throw new InvalidFormatException("فرمت کد ملی صحیح نمی باشد");
        }
        return true;
    }


    public static boolean validateLegalCustomer(String companeyName, String economicId, String registrationDate) throws NullRequiredFieldException, InvalidFormatException {
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

    public boolean validateRealCustomerId(String realCustomerId) throws InvalidEnteranceException{

        if (realCustomerDAO.checkRealCustomerId(realCustomerId)){
            //todo delete realCustomerId
            return true;
        }else{
            throw new InvalidEnteranceException("شماره مشتری وارد شده صحیح نمی باشد٬ لطفا مجددا تلاش کنید");
        }
    }

    public boolean validateLegalCustomerId(String legalCustomerId) throws InvalidEnteranceException{

        if (legalCustomerDAO.checkLegalCustomerId(legalCustomerId)){
            //todo delete legalCustomerId
            return true;
        }else{
            throw new InvalidEnteranceException("شماره مشتری وارد شده صحیح نمی باشد٬ لطفا مجددا تلاش کنید");
        }
    }
}
