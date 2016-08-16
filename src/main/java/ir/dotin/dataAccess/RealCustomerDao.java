package ir.dotin.dataaccess;

import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.utility.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RealCustomerDAO extends Customer {

    Connection connection = null;
    RealCustomer realCustomer = new RealCustomer();

    public boolean checkUniqueRealNationalCode(String nationalCode, int id) throws DuplicateEntranceException {

        connection = SingleConnection.getConnection();
        String query = "SELECT * FROM REAL_CUSTOMER WHERE NATIONAL_CODE = ? AND ID = ?;";
        System.out.println(query);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nationalCode);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                throw new DuplicateEntranceException("کد ملی وارد شده باید یکتا نیست٬ لطفا مجددا تلاش نمایید");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public RealCustomer addRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode) throws DuplicateEntranceException{

        RealCustomer realCustomer = new RealCustomer();
        PreparedStatement preparedStatement = null;
        try {
            int customerNum = CustomerDAO.getMaxCustomerNumber();
            String customerNumber = String.valueOf(customerNum);
            int id = CustomerDAO.addCustomer(customerNumber);
            if (checkUniqueRealNationalCode(nationalCode, id)) {
                connection = SingleConnection.getConnection();
                String query = "INSERT INTO REAL_CUSTOMER(NAME, FAMILY_NAME, FATHER_NAME, BIRTH_DATE, NATIONAL_CODE, ID) VALUES (?, ?, ?, ?, ?, ?);";
                System.out.println(query);
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, familyName);
                preparedStatement.setString(3, fatherName);
                preparedStatement.setString(4, birthDate);
                preparedStatement.setString(5, nationalCode);
                preparedStatement.setInt(6, id);
                preparedStatement.executeUpdate();

                realCustomer.setName(name);
                realCustomer.setFamilyName(familyName);
                realCustomer.setFatherName(fatherName);
                realCustomer.setBirthDate(birthDate);
                realCustomer.setNationalCode(nationalCode);
                realCustomer.setCustomerNumber(customerNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realCustomer;
    }

    public boolean deleteRealCustomer(int id) {

        connection = SingleConnection.getConnection();
        try {
            if (CustomerDAO.deleteCustomer(id)) {
                String query = "DELETE FROM REAL_CUSTOMER WHERE ID = ?;";
                System.out.println(query);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public PreparedStatement searchRealCustomerPreparedStatement(String name, String familyName, String nationalCode, String customerNumber) {

        connection = SingleConnection.getConnection();
        PreparedStatement preparedStatement = null;
        int counter = 1;
        StringBuilder query = new StringBuilder("SELECT * FROM REAL_CUSTOMER REAL_CUSTOMER " +
                "LEFT OUTER JOIN CUSTOMER CUSTOMER ON REAL_CUSTOMER.ID = CUSTOMER.ID WHERE");
        List<String> parameters = new ArrayList<String>();

        if ((customerNumber != null) && (!customerNumber.trim().equals(""))) {
            query.append(" CUSTOMER.CUSTOMER_NUMBER = ? AND ");
            parameters.add(customerNumber);
        }

        if ((name != null) && (!name.trim().equals(""))) {
            query.append(" ID.NAME = ? AND ");
            parameters.add(name);
        }

        if ((familyName != null) && (!familyName.trim().equals(""))) {
            query.append(" ID.FAMILY_NAME = ? AND ");
            parameters.add(familyName);
        }

        if ((nationalCode != null) && (!nationalCode.trim().equals(""))) {
            query.append(" ID.NATIONAL_CODE = ? AND");
            parameters.add(nationalCode);
        }
        query.append(" true ");
        try {
            preparedStatement = connection.prepareStatement(query.toString());
            for (String parameter : parameters) {
                preparedStatement.setString(counter, parameter);
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public ArrayList<RealCustomer> searchRealCustomer(String name, String familyName, String nationalCode, String customerNumber) {
        ArrayList<RealCustomer> realCustomers = new ArrayList<RealCustomer>();
        try {
            PreparedStatement preparedStatement = searchRealCustomerPreparedStatement(name, familyName, nationalCode, customerNumber);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                RealCustomer realCustomer = new RealCustomer();
                realCustomer.setId(results.getInt("ID"));
                realCustomer.setCustomerNumber(CustomerDAO.getCustomerNumberById(results.getInt("ID")));
                realCustomer.setName(results.getString("NAME"));
                realCustomer.setFamilyName(results.getString("FAMILY_NAME"));
                realCustomer.setFatherName(results.getString("FATHER_NAME"));
                realCustomer.setBirthDate(results.getString("BIRTH_DATE"));
                realCustomer.setNationalCode(results.getString("NATIONAL_CODE"));
                realCustomers.add(realCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realCustomers;
    }

    public RealCustomer updateRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode, String customerNumber) throws DuplicateEntranceException {

        connection = SingleConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE REAL_CUSTOMER SET NAME = ? , FAMILY_NAME = ?, FATHER_NAME = ?, BIRTH_DATE = ?, NATIONAL_CODE =  ?  WHERE ID = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, familyName);
            preparedStatement.setString(3, fatherName);
            preparedStatement.setString(4, birthDate);
            preparedStatement.setString(5, nationalCode);
            preparedStatement.executeUpdate();

            realCustomer.setName(name);
            realCustomer.setFamilyName(familyName);
            realCustomer.setFatherName(fatherName);
            realCustomer.setBirthDate(birthDate);
            realCustomer.setNationalCode(nationalCode);
            realCustomer.setCustomerNumber(customerNumber);
        } catch (SQLException e) {
            throw new DuplicateEntranceException("کد اقتصادی وارد شده یکتا نیست٬ لطفا مجددا تلاش نمایید");
        }
        return realCustomer;
    }

    public RealCustomer GetRealCustomer(int id) throws SQLException {

        connection = SingleConnection.getConnection();
        String customerNumber = CustomerDAO.getCustomerNumberById(id);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM REAL_CUSTOMER WHERE ID = ?;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            realCustomer.setId(resultSet.getInt("ID"));
            realCustomer.setName(resultSet.getString("NAME"));
            realCustomer.setFamilyName(resultSet.getString("FAMILY_NAME"));
            realCustomer.setFatherName(resultSet.getString("FATHER_NAME"));
            realCustomer.setBirthDate(resultSet.getString("BIRTH_DATE"));
            realCustomer.setNationalCode(resultSet.getString("NATIONAL_CODE"));
            realCustomer.setCustomerNumber(customerNumber);
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        return realCustomer;
    }
}
