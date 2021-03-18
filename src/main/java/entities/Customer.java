package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@EqualsAndHashCode
public class Customer extends Entity {

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
    }
}