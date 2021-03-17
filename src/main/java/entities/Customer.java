package entities;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

public class Customer {

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

    @Override
    public int hashCode() {

        int hash = 42;
        hash = hash * Objects.hashCode(lastName)*Objects.hashCode(lastName);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null) return false;
        if (object.getClass() != this.getClass()) return false;
        Customer customers = (Customer)object;
        return this.firstName.equals(customers.firstName) && this.lastName.equals(customers.lastName);
    }

    @Override
    public String toString() {
        return "First name: " + firstName + " Last name: " + lastName;
    }
}