package entities;

import interfaces.Order;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.log4j.Logger;

@EqualsAndHashCode
@ToString
public class Cake extends Entity implements Order {

    private final static Logger logger = Logger.getLogger(Cake.class);

    private String name;
    private Float price;
    private Customer customer;
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

    @Override
    public Base getBase() {
        return this.base;
    }

    @Override
    public void deleteDecoration(Decoration decoration) {
    }

    @Override
    public void setBase(Base base)
    {
        this.base = base;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Float getPrice() {
        return this.price;
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Override
    public void addDecoration(Decoration decoration) {
    }

    @Override
    public void addCharacteristic(Characteristic characteristic) {
    }

    @Override
    public void deleteCharacteristic(Characteristic characteristic) {

    }
}
