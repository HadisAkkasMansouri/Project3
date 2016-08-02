package ir.dotin.entities;

public class RealCustomer extends Customer{

    private String name;
    private String familyName;
    private String fatherName;
    private String birthDate;
    private String  nationalId;
    private String realCustomerId;

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getRealCustomerId() {
        return realCustomerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setRealCustomerId(String realCustomerId) {
        this.realCustomerId = realCustomerId;
    }
}
