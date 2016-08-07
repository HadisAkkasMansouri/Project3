package ir.dotin.dataaccess;

import ir.dotin.utility.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LegalCustomerDao {

    Connection connection = null;
    PreparedStatement preparedStatement;

    public LegalCustomerDao() {
        connection = SingleConnection.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    LegalCustomer legalCustomer = null;

    public boolean addLegalCustomer(String companyName, String economicId, String registrationDate, String legalCustomerId) {

        try {
            String query = "insert into legal_customer(COMANEY_NAME, ECONOMIC_ID, REGISTRATION_DATE, CUSTOMER_ID) values(?, ?, ?, ?);";
            System.out.println(query);
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, economicId);
            preparedStatement.setString(3, registrationDate);
            preparedStatement.setString(4, legalCustomerId);
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
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

    public void deleteLegalCustomer(String legalCustomerId) {
        try {
            String query = "delete LEGAL_CUSTOMER where LEGAL_CUSTOMER_ID = ?;";
            System.out.println(query);
            preparedStatement.setString(1, legalCustomerId);
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

    public List<LegalCustomer> searchLegalCustomer(String companyName, String economicId, String legalCustomerId){

        List<LegalCustomer> legalCustomerList = new ArrayList<LegalCustomer>();
        try {
            String query = "select * from LEGAL_CUSTOMER where COMANEY_NAME = ? and ECONOMIC_ID = ?  and CUSTOMER_ID = ?;";
            System.out.println(query);
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, economicId);
            preparedStatement.setString(3, legalCustomerId);
            ResultSet executeQuery = preparedStatement.executeQuery();

            while (executeQuery.next()) {
                LegalCustomer legalCustomer = new LegalCustomer();
                legalCustomer.setCompanyName(executeQuery.getString(1));
                legalCustomer.setEconomicId(executeQuery.getString(2));
                legalCustomer.setRegistrationDate(executeQuery.getString(3));
                legalCustomer.setCustomerId(executeQuery.getString(4));
                legalCustomerList.add(legalCustomer);

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
        return legalCustomerList;
    }
}