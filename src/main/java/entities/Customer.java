package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
}