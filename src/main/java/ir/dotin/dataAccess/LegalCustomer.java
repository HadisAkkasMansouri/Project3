package ir.dotin.dataaccess;

public class LegalCustomer extends Customer {

    private String companyName;
    private String registrationDate;
    private String economicId;
    private String customerId;

    public String getCompanyName() {
        return companyName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getEconomicId() {
        return economicId;
    }

    @Override
    public String getCustomerId() {
        return customerId;
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
    public void setCustomerId(String customerId) {
        super.setCustomerId(customerId);
        this.customerId = customerId;
    }
}