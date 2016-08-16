package ir.dotin.dataaccess;

import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.utility.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LegalCustomerDAO {

    Connection connection = null;
    LegalCustomer legalCustomer = new LegalCustomer();


    public boolean checkUniqueLegalEconomicCode(String economicCode, int id) throws DuplicateEntranceException {

        connection = SingleConnection.getConnection();
        String query = "SELECT * FROM LEGAL_CUSTOMER WHERE ID = ?;";
        System.out.println(query);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, economicCode);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                throw new DuplicateEntranceException("کد اقتصادی وارد شده یکتا نیست٬ لطفا مجددا تلاش نمایید");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public LegalCustomer addLegalCustomer(String companyName, String economicCode, String registrationDate) throws DuplicateEntranceException {

        LegalCustomer legalCustomer = new LegalCustomer();
        PreparedStatement preparedStatement = null;
        try {
            int customerNum = CustomerDAO.getMaxCustomerNumber();
            String customerNumber = String.valueOf(customerNum);
            int id = CustomerDAO.addCustomer(customerNumber);
            if (checkUniqueLegalEconomicCode(companyName, id)) {
                connection = SingleConnection.getConnection();
                String query = "INSERT INTO LEGAL_CUSTOMER(COMPANY_NAME, ECONOMIC_CODE, REGISTRATION_DATE, ID) values(?, ?, ?, ?)";
                System.out.println(query);
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, companyName);
                preparedStatement.setString(2, economicCode);
                preparedStatement.setString(3, registrationDate);
                preparedStatement.setInt(4, id);
                preparedStatement.executeUpdate();

                legalCustomer.setCompanyName(companyName);
                legalCustomer.setEconomicCode(economicCode);
                legalCustomer.setRegistrationDate(registrationDate);
                legalCustomer.setCustomerNumber(customerNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return legalCustomer;
    }

    public boolean deleteLegalCustomer(int id) {

        connection = SingleConnection.getConnection();
        try {
            if (CustomerDAO.deleteCustomer(id)) {
                String query = "DELETE FROM LEGAL_CUSTOMER where ID = ?;";
                System.out.println(query);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public PreparedStatement searchLegalCustomerPreparedStatement(String companyName, String economicCode, String legalCustomerNumber) {

        PreparedStatement preparedStatement = null;
        int counter = 1;
        connection = SingleConnection.getConnection();
        StringBuilder query = new StringBuilder("SELECT * FROM LEGAL_CUSTOMER LEGAL " +
                "LEFT OUTER JOIN CUSTOMER CUSTOMER ON LEGAL.ID = CUSTOMER.ID WHERE");
        List<String> parameters = new ArrayList<String>();
        if ((legalCustomerNumber != null) && (!legalCustomerNumber.trim().equals(""))) {
            query.append(" CUSTOMER.CUSTOMER_NUMBER = ? AND");
            parameters.add(legalCustomerNumber);
        }

        if ((companyName != null) && (!companyName.trim().equals(""))) {
            query.append(" LEGAL.COMPANY_NAME = ? AND");
            parameters.add(companyName);
        }

        if ((economicCode != null) && (!economicCode.trim().equals(""))) {
            query.append(" LEGAL.ECONOMIC_ID = ? AND");
            parameters.add(economicCode);
        }
        query.append(" true");
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

    public ArrayList<LegalCustomer> searchLegalCustomer(String companyName, String economicCode, String legalCustomerNumber) {

        ArrayList<LegalCustomer> legalCustomers = new ArrayList<LegalCustomer>();
        connection = SingleConnection.getConnection();
        try {
            PreparedStatement preparedStatement = searchLegalCustomerPreparedStatement(companyName, economicCode, legalCustomerNumber);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                LegalCustomer legalCustomer = new LegalCustomer();
                legalCustomer.setId(results.getInt("ID"));
                legalCustomer.setCustomerNumber(CustomerDAO.getCustomerNumberById(results.getInt("ID")));
                legalCustomer.setCompanyName(results.getString("COMPANY_NAME"));
                legalCustomer.setEconomicCode(results.getString("ECONOMIC_CODE"));
                legalCustomer.setRegistrationDate(results.getString("REGISTRATION_DATE"));
                legalCustomers.add(legalCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return legalCustomers;
    }

    public LegalCustomer GetLegalCustomer(int id) throws SQLException {

        connection = SingleConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LEGAL_CUSTOMER WHERE ID = ?;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            legalCustomer.setId(resultSet.getInt("ID"));
            legalCustomer.setCompanyName(resultSet.getString("COMPANY_NAME"));
            legalCustomer.setEconomicCode(resultSet.getString("ECONOMIC_CODE"));
            legalCustomer.setRegistrationDate(resultSet.getString("REGISTRATION_DATE"));
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        return legalCustomer;
    }

    public LegalCustomer updateLegalCustomer(String companyName, String registrationDate, String economicCode, String customerNumber) throws DuplicateEntranceException {

        PreparedStatement preparedStatement = null;
        connection = SingleConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE LEGAL_CUSTOMER SET COMPANY_NAME = ?, ECONOMIC_CODE = ?, REGISTRATION_DATE = ?  WHERE ID = ?");
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, economicCode);
            preparedStatement.setString(3, registrationDate);
            preparedStatement.executeUpdate();

            legalCustomer.setCompanyName(companyName);
            legalCustomer.setEconomicCode(economicCode);
            legalCustomer.setRegistrationDate(registrationDate);
            legalCustomer.setCustomerNumber(customerNumber);

        } catch (SQLException e) {
            throw new DuplicateEntranceException("کد اقتصادی وارد شده یکتا نیست٬ لطفا مجددا تلاش نمایید");
        }
        return legalCustomer;
    }

    public boolean checkLegalEconomicId(String economicCode, String customerNumber) {

        connection = SingleConnection.getConnection();
        String query = "SELECT * FROM LEGAL_CUSTOMER WHERE ECONOMIC_CODE = ? AND CUSTOMER_NUMBER != ?;";
        System.out.println(query);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, economicCode);
            preparedStatement.setString(2, customerNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}