package ir.dotin.dataaccess;

public class LegalCustomer extends Customer {

    private String companyName;
    private String registrationDate;
    private String economicId;
    private String customerNumber;

    public String getCompanyName() {
        return companyName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getEconomicId() {
        return economicId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setEconomicId(String economicId) {
        this.economicId = economicId;
    }

    @Override
    public void setCustomerNumber(String customerNumber) {
        super.setCustomerNumber(customerNumber);
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "RealCustomer{" +
                "name ='" + companyName + '\'' +
                ", registrationDate ='" + registrationDate + '\'' +
                ", economicId ='" + economicId + '\'' +
                ", customerId ='" + customerNumber + '\'' +
                '}';
    }
}