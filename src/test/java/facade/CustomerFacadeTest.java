package facade;

import entities.Customer;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.CustomerRepositoryImpl;

public class CustomerFacadeTest extends TestCase {
    CustomerRepositoryImpl customerRepository;
    Customer customer;
    CustomerFacade customerFacade;

    @Before
    public void setUp() {
        customerRepository = Mockito.mock(CustomerRepositoryImpl.class);
        customer = new Customer("Lastname", "Firstname");
        customerFacade = new CustomerFacade(customer, customerRepository);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddCustomer() {
        customerFacade.addCustomer();
        assertEquals(customer, customerFacade.getCustomer());
    }

    @Test
    public void testUpdateCustomer() {
        customerFacade.addCustomer();
        customerFacade.setFirstName("new firstname");
        customerFacade.updateCustomer();
        assertEquals("new firstname", customer.getFirstName());
    }
}