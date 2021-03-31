package facade;

import entities.Customer;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repositoryimpl.CustomerRepositoryImpl;

import static entities.Container.customerList;

public class CustomerFacadeTest extends TestCase {
    CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    CustomerFacade customerFacade;
    Customer customer;

    @Before
    public void setUp() throws Exception {
       customer = new Customer("Lastname", "Firstname");
       customerFacade = new CustomerFacade(customer, customerRepository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddCustomer() {
        customerFacade.addCustomer();
        assertEquals(customer, customerFacade.getCustomer());
    }

    @Test
    public void testRemoveCustomer() {
        customerFacade.addCustomer();
        customerFacade.removeCustomer();
        assertEquals(true, customerList.isEmpty());
    }

    @Test
    public void testUpdateCustomer() {
        customerFacade.addCustomer();
        customerFacade.setFirstName("new firstname");
        customerFacade.updateCustomer();
        assertEquals("new firstname", customer.getFirstName());
    }
}