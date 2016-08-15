package ir.dotin.business;

import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NullRequiredFieldException;

import java.util.ArrayList;

public class CustomerLegalValidation {

    public static LegalCustomer validateAddLegalCustomer(String companyName, String economicCode, String registrationDate) throws NullRequiredFieldException, InvalidEntranceException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        if (!companyName.isEmpty()) {

            if (!economicCode.isEmpty()) {

                if (!registrationDate.isEmpty()) {

                    if (economicCode.length() == 10) {
                        LegalCustomer legalCustomer = legalCustomerDAO.addLegalCustomer(companyName, economicCode, registrationDate);
                        return legalCustomer;
                    }else {
                        throw new InvalidEntranceException("کد اقتصادی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
                    }
                } else {
                    throw new NullRequiredFieldException("وارد نمودن تاریخ ثبت شرکت الزامی است");
                }
            } else {
                throw new NullRequiredFieldException("وارد نمودن کد اقتصادی شرکت الزامی است");
            }
        } else {
            throw new NullRequiredFieldException("وارد نمودن نام شرکت الزامی است");
        }
    }

    public static LegalCustomer validateUpdateLegalCustomer(String companyName, String economicCode, String registrationDate) throws InvalidEntranceException, DuplicateEntranceException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        if (economicCode.length() == 10) {
            LegalCustomer legalCustomer = legalCustomerDAO.updateLegalCustomer(companyName, economicCode, registrationDate);
            return legalCustomer;
        }else {
            throw new InvalidEntranceException("کد اقتصادی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
        }
    }

//    public static ArrayList<LegalCustomer> validateSearchLegalCustomer(String companyName, String economicCode, String legalCustomerNumber) throws InvalidEntranceException {
//
//        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
//        if (economicCode.length() == 10) {
//            ArrayList<LegalCustomer> legalCustomers = legalCustomerDAO.searchLegalCustomer(companyName, economicCode, legalCustomerNumber);
//            return legalCustomers;
//        }else {
//            throw new InvalidEntranceException("کد اقتصادی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
//        }
//    }
}
