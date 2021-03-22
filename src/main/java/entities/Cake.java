package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.log4j.Logger;

import java.util.Objects;

@EqualsAndHashCode
@ToString
public class Cake extends Entity {

    private final static Logger logger = Logger.getLogger(Cake.class);

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
        logger.info("Create cake with name: " + name +
                " price: " + price +
                " customer: " + customer.toString() +
                " base: " + base.toString());
    }
    public Cake(Cake cake)
    {
        this.name = cake.name;
        this.price = cake.getPrice();
        this.setUuid(cake.getUuid());
    }
}
