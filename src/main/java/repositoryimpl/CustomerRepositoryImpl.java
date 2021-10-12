package repositoryimpl;

import entities.Customer;
import org.apache.log4j.Logger;

import java.util.UUID;
import static entities.Container.customerList;



public class CustomerRepositoryImpl {
    private final static Logger logger = Logger.getLogger(CustomerRepositoryImpl.class);
    public Object getCustomerById(UUID uuid)
    {
        for (Customer customer: customerList) {
            if (customer.getUuid().equals(uuid))
            {
                return customer;
            }

        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }

    public void addCustomer(Customer customer)
    {
        customerList.add(new Customer(customer));
        logger.info("Add " + customer.toString() + " in customerList");
    }

    public void updateCustomer(Customer customer)
    {
        for (Customer c: customerList) {
            if (customer.getUuid() == c.getUuid())
            {
                customerList.remove(c);
                customerList.add(customer);
                break;
            }
        }
        logger.info("Update " + customer.toString() + " in customerList");
    }
    public void removeCustomer(Customer customer)
    {
        for (Customer c: customerList) {
            if (customer.getUuid() == c.getUuid())
            {
                customerList.remove(c);
                break;
            }
        }
        logger.info("Delete " + customer.toString() + " in customerList");
    }

}
