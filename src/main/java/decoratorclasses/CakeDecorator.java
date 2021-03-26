package decoratorclasses;

import entities.*;
import interfaces.Order;
import org.apache.log4j.Logger;

import static entities.Container.*;

public class CakeDecorator implements Order {
    private final static Logger logger = Logger.getLogger(Cake.class);

    Order order;
    public CakeDecorator(Order order) {
        this.order = order;
        logger.info("Create CakeDecorator class");
    }

    public void addDecoration(Decoration decoration)
    {
        cakeDecorationList.add(new CakeDecoration((Cake) order, decoration));
        logger.info("Add " + order.toString() + " with " + decoration.toString() + " in cakeDecorationList");
    }
    public void addCharacteristic(Characteristic characteristic)
    {
        cakeCharacteristicList.add(new CakeCharacteristic((Cake) order, characteristic));
        logger.info("Add " + order.toString() + " with " + characteristic.toString() + " in cakeCharacteristicList");
    }

    @Override
    public Base getBase() {
        return order.getBase();
    }
    @Override
    public void setBase(Base base)
    {
        this.order.setBase(base);
    }

    @Override
    public String getName() {
       return order.getName();
    }

    @Override
    public void setName(String name) {
        order.setName(name);
    }

    @Override
    public Customer getCustomer() {
        return order.getCustomer();
    }

    @Override
    public Float getPrice() {
        return order.getPrice();
    }

    @Override
    public void setPrice(Float price) {
        order.setPrice(price);
    }

    @Override
    public void setCustomer(Customer customer) {
        order.setCustomer(customer);
    }
}
