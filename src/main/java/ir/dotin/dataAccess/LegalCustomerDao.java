package ir.dotin.dataaccess;

import ir.dotin.utility.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LegalCustomerDAO {

    private static Connection connection = null;

    public LegalCustomerDAO() {
        connection = SingleConnection.getConnection();
    }

    LegalCustomer legalCustomer = null;

    public LegalCustomer addLegalCustomer(String companyName, String economicId, String registrationDate) {

        LegalCustomer legalCustomer = new LegalCustomer();
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
            String legalCustomerId = String.valueOf(customerId);
            Integer id =  CustomerDAO.addCustomer(customerId);
            String query = "insert into legal_customer(COMPANY_NAME, ECONOMIC_ID, REGISTRATION_DATE, CUSTOMER_ID, ID) values(?, ?, ?, ?, ?)";
            System.out.println(query);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, economicId);
            preparedStatement.setString(3, registrationDate);
            preparedStatement.setString(4, legalCustomerId);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

            legalCustomer.setCustomerNumber(id.toString());
            legalCustomer.setEconomicId(economicId);
            legalCustomer.setRegistrationDate(registrationDate);
            legalCustomer.setCompanyName(companyName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return legalCustomer;
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

    public PreparedStatement searchLegalCustomerPreparedStatement(String companyName, String economicId, String legalCustomerId) {

        PreparedStatement preparedStatement = null;
        int counter = 1;
        StringBuilder query = new StringBuilder("SELECT * FROM LEGAL_CUSTOMER WHERE ");
        List<String> parameters = new ArrayList<String>();
        if ((legalCustomerId != null) && (!legalCustomerId.trim().equals(""))) {
            query.append(" CUSTOMER_ID = ? AND ");
            parameters.add(legalCustomerId);
        }

        if ((companyName != null) && (!companyName.trim().equals(""))) {
            query.append(" COMPANY_NAME = ? AND ");
            parameters.add(companyName);
        }

        if ((economicId != null) && (!economicId.trim().equals(""))) {
            query.append(" ECONOMIC_ID = ? AND ");
            parameters.add(economicId);
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

    public ArrayList<LegalCustomer> searchLegalCustomer(String companyName, String economicId, String legalCustomerId) {
        ArrayList<LegalCustomer> legalCustomers = new ArrayList<LegalCustomer>();
        try {
            PreparedStatement preparedStatement = searchLegalCustomerPreparedStatement(companyName, economicId, legalCustomerId);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                LegalCustomer legalCustomer = new LegalCustomer();
                legalCustomer.setId(results.getInt("ID"));
                legalCustomer.setCompanyName(results.getString("COMPANY_NAME"));
                legalCustomer.setEconomicId(results.getString("ECONOMIC_ID"));
                legalCustomer.setRegistrationDate(results.getString("REGISTRATION_DATE"));
                legalCustomer.setCustomerNumber(results.getString("CUSTOMER_ID"));
                legalCustomers.add(legalCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return legalCustomers;
    }

    public static boolean checkLegalCustomerId(String legalCustomerId) {
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