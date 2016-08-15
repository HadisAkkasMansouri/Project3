package ir.dotin.business;

import ir.dotin.dataaccess.LegalCustomer;
import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NullRequiredFieldException;

public class CustomerLegalValidation {

    public static LegalCustomer validateAddLegalCustomer(String companeyName, String economicCode, String registrationDate) throws NullRequiredFieldException, InvalidEntranceException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        if (!companeyName.isEmpty()) {

            if (!economicCode.isEmpty()) {

                if (!registrationDate.isEmpty()) {

                    if (economicCode.length() == 10) {
                        LegalCustomer legalCustomer = legalCustomerDAO.addLegalCustomer(companeyName, economicCode, registrationDate);
                        return legalCustomer;
                    }
                    throw new InvalidEntranceException("کد اقتصادی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
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
}
