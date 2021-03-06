import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.ArrayList;

@Remote(CustomerInterface.class)
@Stateless
public class CustomerBean implements Serializable, CustomerInterface {

    //    @PersistenceContext(unitName = "PersistenceUnit")
    private EntityManager entityManager = Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
    private Customer customer;
    private ArrayList<Customer> customers;

    @Override
    public ArrayList<Customer> getAllCustomers() {
        customers = (ArrayList<Customer>) entityManager.createQuery("Select c from Customer c", Customer.class).getResultList();
        return customers;
    }

    @Override
    public void addCustomer(String discount, String zip, String name, String address, String stateCode, long creditLimit) {
        customer = new Customer(discount, zip, name, address, stateCode, creditLimit);
        entityManager.persist(customer);
    }

    @Override
    public Customer getCustomerByStateCodeAndCreditLimit(String stateCode, long creditLimit) {
        customer = entityManager.createQuery("Select b fromCcustomer b WHERE b.stateCode='" + stateCode + "' AND b.creditLimit=" + creditLimit, Customer.class).getSingleResult();
        return customer;
    }

}
