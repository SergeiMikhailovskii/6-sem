package model;


import customer.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Model {

    private Statement statement;
    private Connection connection;
    private EntityManager entityManager;

    public Model() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/4lab?useUnicode=true&serverTimezone=UTC", "root", "88fodavoDIMA228");
            statement = connection.createStatement();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
            entityManager = emf.createEntityManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        entityManager.getTransaction().begin();


        entityManager.getTransaction().commit();

        ArrayList<Customer> customers = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getString("phoneNumber"), resultSet.getInt("eMail"), resultSet.getInt("discount"), resultSet.getString("name"),  resultSet.getString("zip")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public ArrayList<Customer> findCustomers(String name, String phoneNumber) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer WHERE name='" + name + "' AND phoneNumber='" + phoneNumber + "'");
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getString("phoneNumber"), resultSet.getInt("eMail"), resultSet.getInt("discount"), resultSet.getString("name"),  resultSet.getString("zip")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public void addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customer (phoneNumber, eMail, discount, name, stateCode, zip) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getPhoneNumber());
            preparedStatement.setInt(2, customer.geteMail());
            preparedStatement.setInt(3, customer.getDiscount());
            preparedStatement.setString(4, customer.getName());
            preparedStatement.setString(5, customer.getZip());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
