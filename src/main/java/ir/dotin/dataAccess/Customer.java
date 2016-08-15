package ir.dotin.dataaccess;

public class Customer {


    private int id;
    private String customerNumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerId) {
        this.customerNumber = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }
}
