package com.mikhailovskii.lab3;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface CustomerInterface {

    ArrayList<Customer> getAllCustomers();

    void addCustomer(String discount, String zip, String name, String address, String stateCode, long creditLimit);

    Customer getCustomerByStateCodeAndCreditLimit(String stateCode, long creditLimit);

}
