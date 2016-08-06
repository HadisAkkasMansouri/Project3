package ir.dotin.presentation;

import ir.dotin.exception.DateFormatException;
import ir.dotin.exception.NullRequiredFieldException;

public class CustomerValidation {

    public boolean validateRealCustomer(){
        return true;
    }

    public static void validateLegalCustomer(String companeyName, String economicId, String registrationDate) throws NullRequiredFieldException, DateFormatException{

        if(companeyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام شرکت اجباری است");
        }
        if(economicId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد اقتصادی شرکت اجباری است");
        }
        if(registrationDate.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن تاریخ ثبت شرکت اجباری است");
        }
    }
}
