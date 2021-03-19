package repositoryImpl;

import entities.Customer;

import java.util.UUID;
import static entities.Container.customerList;


public class CustomerRepositoryImpl {

    public Object getCustomerById(UUID uuid)
    {
        for (Customer customer: customerList) {
            if (customer.getUuid() == uuid)
            {
                return customer;
            }

        }
        return new IllegalArgumentException("This id: " + uuid + "not found");
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
