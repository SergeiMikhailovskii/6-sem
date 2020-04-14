package controller;

import additional_task.House;
import additional_task.Person;
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
    private String address;
    private String name;
    private Customer customer = new Customer();
    private House house = new House();
    private Person person = new Person();

    public NewJSFManagedBean() {
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        customers = model.findCustomers(name, address);
        return "customers";
    }

    public void deleteHouse() {
        model.deleteHouse(house);
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

    public void addHouse() {
        model.addHouse(house);
    }

    public void addPerson() {
        model.addPerson(person);
    }

}
