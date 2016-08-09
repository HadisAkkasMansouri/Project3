package ir.dotin.dataaccess;

import ir.dotin.utility.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RealCustomerDAO {

    Connection connection = null;

    public RealCustomerDAO() {
        connection = SingleConnection.getConnection();
    }

    RealCustomer realCustomer = null;

    public boolean addRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalId) {

        PreparedStatement preparedStatement = null;
        int customerId = 0;
        try {
            String maxId = "select max(customer_id) from real_customer;";
            preparedStatement = connection.prepareStatement(maxId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customerId = resultSet.getInt(1);
            } else {
                customerId = 10000;
            }
            customerId++;
            String legalCustomerId = String.valueOf(customerId);
            String query = "INSERT INTO REAL_CUSTOMER(NAME, FAMILY_NAME, FATHER_NAME, BIRTH_DATE, NATIONAL_ID, CUSTOMER_ID) values (?, ?, ?, ?, ?, ?);";
            System.out.println(query);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, familyName);
            preparedStatement.setString(3, fatherName);
            preparedStatement.setString(4, birthDate);
            preparedStatement.setString(5, nationalId);
            preparedStatement.setString(6, legalCustomerId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void deleteRealCustomer(String realCustomerId) {

        try {
            String query = "DELETE FROM REAL_CUSTOMER WHERE CUSTOMER_ID = ?;";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, realCustomerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RealCustomer> searchRealCustomer(String name, String familyName, String nationalId, String realCustomerId) {

        List<RealCustomer> customerList = new ArrayList<RealCustomer>();
        try {
            String query = "SELECT * FROM REAL_CUSTOMER WHERE NAME = ? and FAMILY_NAME = ? and NATIONAL_ID = ? and REAL_CUSTOMER_ID = ?;";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, familyName);
            preparedStatement.setString(3, nationalId);
            preparedStatement.setString(4, realCustomerId);
            ResultSet executeQuery = preparedStatement.executeQuery();

            while (executeQuery.next()) {
                realCustomer = new RealCustomer();
                realCustomer.setName(executeQuery.getString(1));
                realCustomer.setFamilyName(executeQuery.getString(2));
                realCustomer.setFatherName(executeQuery.getString(3));
                realCustomer.setBirthDate(executeQuery.getString(4));
                realCustomer.setNationalId(executeQuery.getString(5));
                realCustomer.setCustomerId(executeQuery.getString(6));
                customerList.add(realCustomer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public boolean checkRealCustomerId(String realCustomerId) {
        String query = "SELECT * FROM REAL_CUSTOMER WHERE CUSTOMER_ID = ?;";
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
}
