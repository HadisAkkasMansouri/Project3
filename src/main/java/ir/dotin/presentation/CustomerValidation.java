package ir.dotin.presentation;

import ir.dotin.exception.InvalidFormatException;
import ir.dotin.exception.NullRequiredFieldException;

public class CustomerValidation {

    public static void validateRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalId) throws NullRequiredFieldException, InvalidFormatException {

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
    }


    public static void validateLegalCustomer(String companeyName, String economicId, String registrationDate) throws NullRequiredFieldException, InvalidFormatException {

        if(companeyName.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن نام شرکت اجباری است");
        }

        if(economicId.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن کد اقتصادی شرکت اجباری است");
        }

        if(registrationDate.isEmpty()){
            throw new NullRequiredFieldException("وارد نمودن تاریخ ثبت شرکت اجباری است");
        }

        if(registrationDate.length() < 10 || registrationDate.length() > 10){
            throw new InvalidFormatException("فرمت تاریخ ثبت شرکت صحیح نمی باشد");
        }
    }
}
