package repositoryimpl;

import entities.Customer;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static entities.Container.customerList;

public class CustomerRepositoryImplTest extends TestCase {

    CustomerRepositoryImpl customerRepository;
    Customer customer;

    @Before
    public void setUp() {
        customerRepository = new CustomerRepositoryImpl();
        customer = new Customer("last name", "first name");
        customerRepository.addCustomer(customer);
    }

    @After
    public void tearDown() {
        customerList.clear();
    }

    @Test
    public void testGetCustomerById() {
        assertEquals(customer, customerRepository.getCustomerById(customer.getUuid()));
    }

    @Test
    public void testUpdateCustomer() {
        customer.setLastName("new last name");
        customerRepository.updateCustomer(customer);
        assertEquals(customer, customerRepository.getCustomerById(customer.getUuid()));
    }

    @Test
    public void testRemoveCustomer() {
        customerRepository.removeCustomer(customer);
        assertFalse(customerList.contains(customer));
    }
}