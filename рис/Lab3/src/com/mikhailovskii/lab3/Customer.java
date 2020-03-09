package com.mikhailovskii.lab3;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private long id;
    private String discount;
    private String zip;
    private String name;
    private String address;
    private String stateCode;
    private long creditLimit;

    public Customer() {
        super();
    }

    public Customer(
            String discount,
            String zip,
            String name,
            String address,
            String stateCode,
            long creditLimit
    ) {
        super();
        this.discount = discount;
        this.zip = zip;
        this.name = name;
        this.address = address;
        this.stateCode = stateCode;
        this.creditLimit = creditLimit;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(long creditLimit) {
        this.creditLimit = creditLimit;
    }



}
