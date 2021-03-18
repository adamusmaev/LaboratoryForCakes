package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@EqualsAndHashCode
@ToString
public class Cake extends Entity {

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
}