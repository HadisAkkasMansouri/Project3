package ir.dotin.dataaccess.entity;

import ir.dotin.dataaccess.entity.Customer;

public class RealCustomer extends Customer {

    private String name;
    private String familyName;
    private String fatherName;
    private String birthDate;
    private String  nationalCode;
    private int id;

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

    public String getNationalCode() {
        return nationalCode;
    }

    @Override
    public int getId() {
        return id;
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

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }



    @Override
    public void setId(int id) {
        super.setId(id);
        this.id = id;
    }

    @Override
    public String toString() {
        return "RealCustomer{" +
                "name ='" + name + '\'' +
                ", family ='" + familyName + '\'' +
                ", fatherName ='" + fatherName + '\'' +
                ", birthDate ='" + birthDate + '\'' +
                ", nationalCode ='" + nationalCode + '\'' +
                ", id ='" + id + '\'' +
                '}';
    }
}
