package ir.dotin.entities;

public class LegalCustomer extends Customer{

    private String companyName;
    private String registrationDate;
    private String economicId;
    private String legalCustomerId;

    public String getCompanyName() {
        return companyName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getEconomicId() {
        return economicId;
    }

    public String getLegalCustomerId() {
        return legalCustomerId;
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

    public void setLegalCustomerId(String legalCustomerId) {
        this.legalCustomerId = legalCustomerId;
    }
}
