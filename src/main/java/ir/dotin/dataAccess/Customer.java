package ir.dotin.dataaccess;

public abstract class Customer {


    private int id;
    private String customerId;


    public int getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerNumber='" + customerId + '\'' +
                '}';
    }
}
