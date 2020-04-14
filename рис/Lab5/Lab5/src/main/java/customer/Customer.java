package customer;

public class Customer {

    private String address;
    private int creditLimit;
    private int discount;
    private String name;
    private String stateCode;
    private String zip;

    public Customer(String address, int creditLimit, int discount, String name, String stateCode, String zip) {
        this.address = address;
        this.creditLimit = creditLimit;
        this.discount = discount;
        this.name = name;
        this.stateCode = stateCode;
        this.zip = zip;
    }

    public Customer() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
