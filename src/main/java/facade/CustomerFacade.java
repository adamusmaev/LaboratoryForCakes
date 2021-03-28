package facade;

import entities.Customer;
import repositoryimpl.CustomerRepositoryImpl;

import java.util.UUID;

public class CustomerFacade {

    private Customer customer;
    private CustomerRepositoryImpl customerRepository;

    public CustomerFacade(Customer customer, CustomerRepositoryImpl customerRepository) {
        this.customer = customer;
        this.customerRepository = customerRepository;
    }

    public Object getCustomerById(UUID uuid) {
        return customerRepository.getCustomerById(uuid);
    }

    public void addCustomer()
    {
        customerRepository.addCustomer(customer);
    }
    public void removeCustomer()
    {
        customerRepository.removeCustomer(customer);
    }
    public void updateCustomer()
    {
        customerRepository.updateCustomer(customer);
    }
    public String getFirstName()
    {
        return customer.getFirstName();
    }
    public void setFirstName(String firstName)
    {
        customer.setFirstName(firstName);
    }
    public String getLastName()
    {
        return customer.getLastName();
    }
    public void setLastName(String lastname)
    {
        customer.setLastName(lastname);
    }
}
