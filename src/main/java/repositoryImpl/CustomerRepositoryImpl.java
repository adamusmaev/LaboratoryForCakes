package repositoryImpl;

import entities.Customer;
import org.apache.log4j.Logger;

import java.util.UUID;
import static entities.Container.customerList;


public class CustomerRepositoryImpl {
    private final static Logger logger = Logger.getLogger(BaseRepositoryImpl.class);


    public Object getCustomerById(UUID uuid)
    {
        for (Customer customer: customerList) {
            if (customer.getUuid() == uuid)
            {
                return customer;
            }

        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }

    public void addCustomer(Customer customer)
    {
        customerList.add(customer);
    }

    public void update(Customer customer)
    {
        for (int i = 0; i < customerList.size(); i++)
        {
            if (customer.equals(customerList.get(i)))
            {
                customerList.set(i, customer);
                break;
            }
        }
    }
    public void removeCustomer(Customer customer)
    {
        for (int i = 0; i < customerList.size(); i++)
        {
            if (customer.equals(customerList.get(i)))
            {
                customerList.remove(i);
                break;
            }
        }
    }

}
