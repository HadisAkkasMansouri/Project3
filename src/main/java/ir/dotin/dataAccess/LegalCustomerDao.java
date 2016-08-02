package ir.dotin.dataAccess;

import ir.dotin.entities.LegalCustomer;
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

//    LegalCustomer legalCustomer = new LegalCustomer();

    public boolean addLegalCustomer(LegalCustomer legalCustomer) {

        try {
            String query = "insert into legal_customer(COMANEY_NAME, ECONOMIC_ID, REGISTRATION_DATE, LEGAL_CUSTOMER_ID) values();";
            System.out.println(query);
            preparedStatement.setString(1, legalCustomer.getCompanyName());
            preparedStatement.setString(2, legalCustomer.getEconomicId());
            preparedStatement.setString(3, legalCustomer.getRegistrationDate());
            preparedStatement.setString(4, legalCustomer.getLegalCustomerId());
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
            preparedStatement.setString(1, legalCustomer.getLegalCustomerId());
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

    public List<LegalCustomer> searchLegalCustomer(String companyName, String economicId, String legalCustomerId) {
        List<LegalCustomer> legalCustomerList = new ArrayList<LegalCustomer>();
        try {
            String query = "select * from LEGAL_CUSTOMER where COMANEY_NAME = ? and ECONOMIC_ID = ?  and LEGAL_CUSTOMER_ID = ?;";
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
                legalCustomer.setLegalCustomerId(executeQuery.getString(3));
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

    public LegalCustomer searchLegalCustomerWithEI(String legalCustomerId) {

        try {
            String query = "select * from LEGAL_CUSTOMER where LEGAL_CUSTOMER_ID = ?";
            System.out.println(query);
            preparedStatement.setString(1, legalCustomerId);
            ResultSet executeQuery = preparedStatement.executeQuery();

            while (executeQuery.next()) {
                LegalCustomer legalCustomer = new LegalCustomer();
                legalCustomer.setCompanyName(executeQuery.getString(1));
                legalCustomer.setRegistrationDate(executeQuery.getString(2));
                legalCustomer.setEconomicId(executeQuery.getString(3));
                legalCustomer.setLegalCustomerId(executeQuery.getString(4));
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
        return legalCustomer;
    }
}