package ir.dotin.dataaccess.entity;

import ir.dotin.dataaccess.entity.Customer;

public class LegalCustomer extends Customer {

    private String companyName;
    private String registrationDate;
    private String economicCode;
    private int id;

    public String getCompanyName() {
        return companyName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    @Override
    public void setId(int id) {
        super.setId(id);
        this.id = id;
    }

    @Override
    public String toString() {
        return "RealCustomer{" +
                "name ='" + companyName + '\'' +
                ", registrationDate ='" + registrationDate + '\'' +
                ", economicId ='" + economicCode + '\'' +
                ", id ='" + id + '\'' +
                '}';
    }
}