package customer;

public class Customer {

    private String phoneNumber;
    private int eMail;
    private int discount;
    private String name;

    private String zip;

    public Customer(String phoneNumber, int eMail, int discount, String name , String zip) {
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.discount = discount;
        this.name = name;
        this.zip = zip;
    }

    public Customer() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int geteMail() {
        return eMail;
    }

    public void seteMail(int eMail) {
        this.eMail = eMail;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
