package ir.dotin.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SingleConnection {

    Logger logger = Logger.getLogger("connectionLog");
    private Connection connect = null;
    private static SingleConnection instance = new SingleConnection();

    private SingleConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dotin?useUnicode=true&characterEncoding=UTF-8", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            logger.severe("The connection to DataBase is aborted!");
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
