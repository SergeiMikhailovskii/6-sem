package controller;


import customer.Customer;
import model.Model;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "newMB")
@SessionScoped
public class NewJSFManagedBean implements Serializable {

    private Model model = new Model();
    private List<Customer> customers;
    private String phoneNumber;
    private String name;
    private Customer customer = new Customer();


    public NewJSFManagedBean() {
    }


    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String moveToCustomers() {
        customers = model.getAllCustomers();
        System.out.println("Size: " + customers.size());
        return "customers";
    }

    public String moveToSearchCustomers() {
        customers = model.findCustomers(name, phoneNumber);
        return "customers";
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addCustomer() {
        model.addCustomer(customer);
    }

}
