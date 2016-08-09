package ir.dotin.dataaccess;

import ir.dotin.utility.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LegalCustomerDAO {

    Connection connection = null;

    public LegalCustomerDAO() {
        connection = SingleConnection.getConnection();
    }

    LegalCustomer legalCustomer = null;

    public boolean addLegalCustomer(String companyName, String economicId, String registrationDate) {
        PreparedStatement preparedStatement = null;
        int customerId = 0;
        try {
            String maxId = "select max(customer_id) from legal_customer;";
            preparedStatement = connection.prepareStatement(maxId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customerId = resultSet.getInt(1);
            } else {
                customerId = 10000;
            }
            customerId++;
            String legalCustomerId = String.valueOf(customerId);
            String query = "insert into legal_customer(COMPANY_NAME, ECONOMIC_ID, REGISTRATION_DATE, CUSTOMER_ID) values(?, ?, ?, ?)";
            System.out.println(query);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, economicId);
            preparedStatement.setString(3, registrationDate);
            preparedStatement.setString(4, legalCustomerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void deleteLegalCustomer(String legalCustomerId) {
        try {
            String query = "delete FROM LEGAL_CUSTOMER where CUSTOMER_ID = ?;";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, legalCustomerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LegalCustomer> searchLegalCustomer(String companyName, String economicId, String legalCustomerId) {

        List<LegalCustomer> legalCustomerList = new ArrayList<LegalCustomer>();
        try {
            String query = "select * from LEGAL_CUSTOMER where COMANEY_NAME = ? and ECONOMIC_ID = ?  and CUSTOMER_ID = ?;";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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
        }
        return legalCustomerList;
    }

    public boolean checkLegalCustomerId(String legalCustomerId) {
        String query = "select * from LEGAL_CUSTOMER where CUSTOMER_ID = ?;";
        System.out.println(query);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, legalCustomerId);
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