package ir.dotin.dataaccess;

import com.mysql.jdbc.Statement;
import ir.dotin.utility.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RealCustomerDAO extends Customer {

    private static Connection connection = null;

    public RealCustomerDAO() {
        connection = SingleConnection.getConnection();
    }

    public RealCustomer addRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalId) {

        RealCustomer realCustomer = new RealCustomer();
        PreparedStatement preparedStatement = null;
        int customerId = 0;
        try {
            String maxId = "select max(customer_id) from customer;";
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
            String query = "INSERT INTO REAL_CUSTOMER(NAME, FAMILY_NAME, FATHER_NAME, BIRTH_DATE, NATIONAL_ID, CUSTOMER_ID , ID) values (?, ?, ?, ?, ?,?, ?);";
            System.out.println(query);
            preparedStatement = connection.prepareStatement(query , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, familyName);
            preparedStatement.setString(3, fatherName);
            preparedStatement.setString(4, birthDate);
            preparedStatement.setString(5, nationalId);
            preparedStatement.setString(6, realCustomerNumbre);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();


            realCustomer.setCustomerNumber(id.toString());
            realCustomer.setBirthDate(birthDate);
            realCustomer.setFamilyName(familyName);
            realCustomer.setFatherName(fatherName);
            realCustomer.setNationalId(nationalId);
            realCustomer.setCustomerNumber(realCustomerNumbre);
            realCustomer.setName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return realCustomer;
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

    public PreparedStatement searchRealCustomerPreparedStatement(String name, String familyName, String nationalId, String realCustomerId) {

        PreparedStatement preparedStatement = null;
        int counter = 1;
        StringBuilder query = new StringBuilder("SELECT * FROM REAL_CUSTOMER WHERE ");
        List<String> parameters = new ArrayList<String>();
        if ((realCustomerId != null) && (!realCustomerId.trim().equals(""))) {
            query.append(" CUSTOMER_ID = ? AND ");
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
                realCustomer.setId(results.getInt("id"));
                realCustomer.setName(results.getString("name"));
                realCustomer.setFamilyName(results.getString("family_Name"));
                realCustomer.setFatherName(results.getString("father_Name"));
                realCustomer.setBirthDate(results.getString("birth_Date"));
                realCustomer.setNationalId(results.getString("national_Id"));
                realCustomer.setCustomerNumber(results.getString("customer_Id"));
                realCustomers.add(realCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realCustomers;
    }

    public static boolean checkRealCustomerId(String realCustomerId) {
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
