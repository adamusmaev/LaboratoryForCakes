package Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


public class Customers {

    @Getter
    private Integer id;
    private int hash;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String firstName;

    public Customers(String lastName, String firstName)
    {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public int hashCode() {
        id = super.hashCode();
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null) return false;
        if (object.getClass() != this.getClass()) return false;
        Customers customers = (Customers)object;
        return this.firstName.equals(customers.lastName) && this.lastName.equals(customers.lastName);
    }

    @Override
    public String toString() {
        return "First name: " + firstName + " Lastname: " + lastName;
    }
}
