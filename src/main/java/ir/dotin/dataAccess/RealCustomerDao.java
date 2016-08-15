package ir.dotin.dataaccess;

import com.mysql.jdbc.Statement;
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

    public RealCustomer addRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode) {

        connection = SingleConnection.getConnection();
        RealCustomer realCustomer = new RealCustomer();
        PreparedStatement preparedStatement = null;
        int customerId = 0;
        try {
            String maxId = "SELECT MAX(CUSTOMER_ID) FROM CUSTOMER;";
            preparedStatement = connection.prepareStatement(maxId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customerId = resultSet.getInt(1);
            } else {
                customerId = 10000;
            }
            customerId++;
            String realCustomerNumbre = String.valueOf(customerId);
            Integer id =  CustomerDAO.addCustomer(customerId);
            String query = "INSERT INTO REAL_CUSTOMER(NAME, FAMILY_NAME, FATHER_NAME, BIRTH_DATE, NATIONAL_CODE, CUSTOMER_NUMBER , ID) VALUES (?, ?, ?, ?, ?,?, ?);";
            System.out.println(query);
            preparedStatement = connection.prepareStatement(query , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, familyName);
            preparedStatement.setString(3, fatherName);
            preparedStatement.setString(4, birthDate);
            preparedStatement.setString(5, nationalCode);
            preparedStatement.setString(6, realCustomerNumbre);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();

            realCustomer.setCustomerNumber(id.toString());
            realCustomer.setBirthDate(birthDate);
            realCustomer.setFamilyName(familyName);
            realCustomer.setFatherName(fatherName);
            realCustomer.setNationalCode(nationalCode);
            realCustomer.setCustomerNumber(realCustomerNumbre);
            realCustomer.setName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return realCustomer;
    }

    public void deleteRealCustomer(String realCustomerId) {

        connection = SingleConnection.getConnection();
        try {
            String query = "DELETE FROM REAL_CUSTOMER WHERE CUSTOMER_NUMBER = ?;";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, realCustomerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement searchRealCustomerPreparedStatement(String name, String familyName, String nationalId, String realCustomerId) {

        connection = SingleConnection.getConnection();
        PreparedStatement preparedStatement = null;
        int counter = 1;
        StringBuilder query = new StringBuilder("SELECT * FROM REAL_CUSTOMER WHERE ");
        List<String> parameters = new ArrayList<String>();
        if ((realCustomerId != null) && (!realCustomerId.trim().equals(""))) {
            query.append(" CUSTOMER_NUMBER = ? AND ");
            parameters.add(realCustomerId);
        }

        if ((name != null) && (!name.trim().equals(""))) {
            query.append(" NAME = ? AND ");
            parameters.add(name);
        }

        if ((familyName != null) && (!familyName.trim().equals(""))) {
            query.append(" FAMILY_NAME = ? AND ");
            parameters.add(familyName);
        }

        if ((nationalId != null) && (!nationalId.trim().equals(""))) {
            query.append(" NATIONAL_ID = ? AND");
            parameters.add(nationalId);
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

    public ArrayList<RealCustomer> searchRealCustomer(String name, String familyName, String nationalId, String customerId) {
        ArrayList<RealCustomer> realCustomers = new ArrayList<RealCustomer>();
        try {
            PreparedStatement preparedStatement = searchRealCustomerPreparedStatement(name, familyName, nationalId, customerId);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                RealCustomer realCustomer = new RealCustomer();
                realCustomer.setId(results.getInt("ID"));
                realCustomer.setName(results.getString("NAME"));
                realCustomer.setFamilyName(results.getString("FAMILY_NAME"));
                realCustomer.setFatherName(results.getString("FATHER_NAME"));
                realCustomer.setBirthDate(results.getString("BIRTH_DATE"));
                realCustomer.setNationalCode(results.getString("NATIONAL_ID"));
                realCustomer.setCustomerNumber(results.getString("CUSTOMER_NUMBER"));
                realCustomers.add(realCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realCustomers;
    }

    public boolean checkRealCustomerId(String realCustomerId) {

        connection = SingleConnection.getConnection();
        String query = "SELECT * FROM REAL_CUSTOMER WHERE CUSTOMER_NUMBER = ?;";
        System.out.println(query);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, realCustomerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public RealCustomer updateRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode) throws DuplicateEntranceException{

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
        } catch (SQLException e) {
            throw new DuplicateEntranceException("یکتا بودن کد ملی الزامی است‌ لطفا مجددا تلاش نمایید");
        }
        return realCustomer;
    }

    public boolean checkRealNationalId(String nationalId, String customerNumber) {

        connection = SingleConnection.getConnection();
        String query = "SELECT * FROM REAL_CUSTOMER WHERE NATIONAL_ID = ? AND CUSTOMER_NUMBER=?;";
        System.out.println(query);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nationalId);
            preparedStatement.setString(2, customerNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public RealCustomer GetRealCustomer(int id) throws SQLException {

        connection = SingleConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM REAL_CUSTOMER WHERE CUSTOMER_NUMBER = ?;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            realCustomer.setId(resultSet.getInt("ID"));
            realCustomer.setName(resultSet.getString("NAME"));
            realCustomer.setFamilyName(resultSet.getString("FAMILY_NAME"));
            realCustomer.setFatherName(resultSet.getString("FATHER_NAME"));
            realCustomer.setBirthDate(resultSet.getString("BIRTH_DATE"));
            realCustomer.setNationalCode(resultSet.getString("NATIONAL_ID"));
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        return realCustomer;
    }
}
