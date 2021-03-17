package Entities;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

public class Cake {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Float price;


    @Getter
    @Setter
    private Customer customer;

    @Getter
    @Setter
    private Base base;

    public Cake(String name, Float price, Customer customer, Base base)
    {
        this.name = name;
        this.price = price;
        this.customer = customer;
        this.base = base;
    }

    @Override
    public int hashCode()
    {
        int hash = 1;
        hash = hash * Objects.hashCode(name) + Objects.hashCode(customer);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null) return false;
        if (object.getClass() != this.getClass()) return false;
        Cake cake = (Cake)object;
        return this.name.equals(cake.name) && this.price.equals(cake.price) && this.customer.equals(cake.customer);
    }

    @Override
    public String toString()
    {
        return "Name:" + name + " Prise: " + " Customer: " + customer;
    }
}
