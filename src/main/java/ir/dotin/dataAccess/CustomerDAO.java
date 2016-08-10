package ir.dotin.dataaccess;

import com.mysql.jdbc.Statement;
import ir.dotin.utility.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    private static Connection connection = null;

    public static int addCustomer(int customerId) throws SQLException {
        connection = SingleConnection.getConnection();
        String query = "INSERT INTO CUSTOMER(CUSTOMER_ID) values (?);";
        System.out.println(query);
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, customerId);
        int results = preparedStatement.executeUpdate();
        int id = 0;
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if(generatedKeys.next())
        {
            id = generatedKeys.getInt(1);
        }
        return id;
    }
}
