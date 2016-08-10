package ir.dotin.dataaccess;

public abstract class Customer {


    private int id;
    private String customerNumber;


    public int getId() {
        return id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerId) {
        this.customerNumber = customerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }
}
