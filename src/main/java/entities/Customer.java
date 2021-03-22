package entities;

import lombok.*;
import org.apache.log4j.Logger;


@ToString
@EqualsAndHashCode
public class Customer extends Entity {
    private static final Logger logger = Logger.getLogger(Customer.class);

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String firstName;

    public Customer(String lastName, String firstName)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        logger.info("Create customer with lastname: " + lastName +
                " firstname: " + firstName);
    }
    public Customer(Customer customer)
    {
        this.lastName = customer.lastName;
        this.firstName = customer.firstName;
        this.setUuid(customer.getUuid());
        logger.info("Create customer with lastname: " + lastName +
                " firstname: " + firstName);
    }
}