package ir.dotin.dataAccess;

import ir.dotin.entities.RealCustomer;
import ir.dotin.utility.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RealCustomerDao {

    Connection connection = null;
    PreparedStatement preparedStatement;

    public RealCustomerDao() {
        connection = SingleConnection.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    RealCustomer realCustomer = new RealCustomer();

    public boolean addRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalId) {

        try {
            String query = "insert into REAL_CUSTOMER(NAME, FAMILY_NAME, FATHER_NAME, BIRTH_DATE, NATIONAL_ID, REAL_CUSTOMER_ID) values (?, ?, ?, ?, ?, ?);";
            System.out.println(query);
            preparedStatement.setString(1, realCustomer.getName());
            preparedStatement.setString(2, realCustomer.getFamilyName());
            preparedStatement.setString(3, realCustomer.getFatherName());
            preparedStatement.setString(4, realCustomer.getBirthDate());
            preparedStatement.setString(5, realCustomer.getNationalId());
            //????       preparedStatement.setString(6, realCustomer.getRealCustomerId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void deleteRealCustomer(String realCustomerId) {

        try {
            String query = "delete REAL_CUSTOMER where REAL_CUSTOMER_ID = ?;";
            System.out.println(query);
            preparedStatement.setString(1, realCustomer.getRealCustomerId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<RealCustomer> searchRealCustomer(String name, String familyName, String nationalId, String realCustomerId) {
        List<RealCustomer> customerList = new ArrayList<RealCustomer>();
        try {
            String query = "select * from REAL_CUSTOMER where NAME = ? and FAMILY_NAME = ? and NATIONAL_ID = ? and REAL_CUSTOMER_ID = ?;";
            System.out.println(query);
            preparedStatement.setString(1, realCustomer.getName());
            preparedStatement.setString(2, realCustomer.getFamilyName());
            preparedStatement.setString(3, realCustomer.getNationalId());
            preparedStatement.setString(4, realCustomer.getRealCustomerId());
            ResultSet executeQuery = preparedStatement.executeQuery();

            while (executeQuery.next()) {
                realCustomer.setName(executeQuery.getString(1));
                realCustomer.setFamilyName(executeQuery.getString(2));
                realCustomer.setFatherName(executeQuery.getString(3));
                realCustomer.setBirthDate(executeQuery.getString(4));
                realCustomer.setNationalId(executeQuery.getString(5));
                realCustomer.setRealCustomerId(executeQuery.getString(6));
                customerList.add(realCustomer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    public RealCustomer searchRealCustomerWithNI(String realCustomerId) {

        try {
            String query = "select * from REAL_CUSTOMER where REAL_CUSTOMER_ID = ?";
            System.out.println(query);
            preparedStatement.setString(4, realCustomer.getRealCustomerId());
            ResultSet executeQuery = preparedStatement.executeQuery();

            while (executeQuery.next()) {
                realCustomer.setName(executeQuery.getString(1));
                realCustomer.setFamilyName(executeQuery.getString(2));
                realCustomer.setFatherName(executeQuery.getString(3));
                realCustomer.setBirthDate(executeQuery.getString(4));
                realCustomer.setNationalId(executeQuery.getString(5));
                realCustomer.setRealCustomerId(executeQuery.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return realCustomer;
    }
}
