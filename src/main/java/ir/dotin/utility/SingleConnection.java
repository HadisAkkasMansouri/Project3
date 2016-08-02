package ir.dotin.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {

    private Connection connect = null;
    private static SingleConnection instance = new SingleConnection();

    private SingleConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=123qweasdZXC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SingleConnection getInstance(){
        return instance;
    }

    public static Connection getConnection(){
        return instance.connect;
    }
}
