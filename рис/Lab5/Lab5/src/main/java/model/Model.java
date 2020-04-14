package model;

import additional_task.House;
import additional_task.Person;
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab3?useUnicode=true&serverTimezone=UTC", "root", "12345");
            statement = connection.createStatement();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
            entityManager = emf.createEntityManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        entityManager.getTransaction().begin();

        entityManager.persist(new House("Address1", 1));
        entityManager.persist(new Person("Person1", 1));
        entityManager.persist(new Person("Person2", 1));

        entityManager.getTransaction().commit();

        ArrayList<Customer> customers = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getString("address"), resultSet.getInt("creditLimit"), resultSet.getInt("discount"), resultSet.getString("name"), resultSet.getString("stateCode"), resultSet.getString("zip")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public ArrayList<Customer> findCustomers(String name, String address) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer WHERE name='" + name + "' AND address='" + address + "'");
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getString("address"), resultSet.getInt("creditLimit"), resultSet.getInt("discount"), resultSet.getString("name"), resultSet.getString("stateCode"), resultSet.getString("zip")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public void addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customer (address, creditLimit, discount, name, stateCode, zip) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getAddress());
            preparedStatement.setInt(2, customer.getCreditLimit());
            preparedStatement.setInt(3, customer.getDiscount());
            preparedStatement.setString(4, customer.getName());
            preparedStatement.setString(5, customer.getStateCode());
            preparedStatement.setString(6, customer.getZip());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addHouse(House house) {
        entityManager.getTransaction().begin();

        entityManager.persist(house);

        entityManager.getTransaction().commit();
    }

    public void addPerson(Person person) {
        entityManager.getTransaction().begin();

        entityManager.persist(person);

        entityManager.getTransaction().commit();
    }

    public void deleteHouse(House house) {
        entityManager.getTransaction().begin();

        entityManager.createQuery("DELETE FROM Person WHERE houseId=" + house.getIdHouse()).executeUpdate();

        entityManager.remove(entityManager.contains(house) ? house : entityManager.merge(house));

        entityManager.getTransaction().commit();
    }

}
