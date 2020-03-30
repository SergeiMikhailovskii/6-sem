import javax.persistence.*;

@Entity
public class Customer {
    private int id;
    private String discount;
    private String zip;
    private String name;
    private String address;
    private String stateCode;
    private long creditLimit;

    public Customer() {
    }

    public Customer(String discount, String zip, String name, String address, String stateCode, long creditLimit) {
        this.discount = discount;
        this.zip = zip;
        this.name = name;
        this.address = address;
        this.stateCode = stateCode;
        this.creditLimit = creditLimit;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Basic
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @Basic
    public long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(long creditLimit) {
        this.creditLimit = creditLimit;
    }
}
