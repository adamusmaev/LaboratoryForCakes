package entities;

import intarfaces.Storable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@ToString
@EqualsAndHashCode
public class Customer implements Storable {

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