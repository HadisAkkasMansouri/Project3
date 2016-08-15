package ir.dotin.business;

import ir.dotin.dataaccess.RealCustomer;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NullRequiredFieldException;

public class CustomerRealValidation {

    public static RealCustomer validateAddRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode) throws NullRequiredFieldException, InvalidEntranceException, DuplicateEntranceException {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        if (!name.isEmpty()) {

            if (!familyName.isEmpty()) {

                if (!fatherName.isEmpty()) {

                    if (!birthDate.isEmpty()) {

                        if (!nationalCode.isEmpty()) {

                            if (nationalCode.length() == 10) {
                                RealCustomer realCustomer = realCustomerDAO.addRealCustomer(name, familyName, fatherName, birthDate, nationalCode);
                                return realCustomer;
                            }
                            throw new InvalidEntranceException("کد ملی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
                        } else {
                            throw new NullRequiredFieldException("وارد نمودن کد ملی الزامی است");
                        }
                    } else {
                        throw new NullRequiredFieldException("وارد نمودن تاریخ تولد الزامی است");
                    }
                } else {
                    throw new NullRequiredFieldException("وارد نمودن نام پدر الزامی است");
                }
            } else {
                throw new NullRequiredFieldException("وارد نمودن نام خانوادگی الزامی است");
            }
        } else {
            throw new NullRequiredFieldException("وارد نمودن فیلد نام الزامی است");
        }
    }

    public static RealCustomer validateUpdateRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode, String customerNumber) throws InvalidEntranceException, DuplicateEntranceException {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        if (nationalCode.length() == 10) {
            RealCustomer realCustomer = realCustomerDAO.updateRealCustomer(name, familyName, fatherName, birthDate, nationalCode, customerNumber);
            return realCustomer;
        }
        throw new InvalidEntranceException("کد ملی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
    }
}
