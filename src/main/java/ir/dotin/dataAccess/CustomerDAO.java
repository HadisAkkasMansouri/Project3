package ir.dotin.dataaccess;

import com.mysql.jdbc.Statement;
import ir.dotin.utility.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    public static Connection connection = null;

    public static int addCustomer(int id, String customerNumber) throws SQLException {
        connection = SingleConnection.getConnection();
        String query = "INSERT INTO CUSTOMER(ID, CUSTOMER_NUMBER) values (?, ?);";
        System.out.println(query);
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, customerNumber);
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            id = generatedKeys.getInt(1);
        }
        return id;
    }

    public static String getMaxCustomerNumber() {
        PreparedStatement preparedStatement = null;
        String customerNumber = null;
        try {
            connection = SingleConnection.getConnection();
            String query = "SELECT MAX(CUSTOMER_NUMBER) FROM CUSTOMER;";
            System.out.println(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customerNumber = resultSet.getString(1);
            } else {
                customerNumber = String.valueOf(10000);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerNumber;
    }

    public static boolean deleteCustomer(int id) {

        try {
            String query1 = "DELETE FROM CUSTOMER WHERE ID = ?;";
            System.out.println(query1);
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
