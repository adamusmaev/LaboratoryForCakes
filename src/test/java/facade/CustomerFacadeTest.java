package facade;

import entities.Customer;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.CustomerRepositoryImpl;

import static entities.Container.customerList;

public class CustomerFacadeTest extends TestCase {
    CustomerRepositoryImpl customerRepository = Mockito.mock(CustomerRepositoryImpl.class);
    Customer customer = new Customer("Lastname", "Firstname");
    CustomerFacade customerFacade = new CustomerFacade(customer, customerRepository);

    @Before
    public void setUp() {
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