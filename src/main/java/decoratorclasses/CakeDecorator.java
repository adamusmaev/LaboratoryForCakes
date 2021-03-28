package decoratorclasses;

import entities.*;
import interfaces.Order;
import lombok.ToString;
import org.apache.log4j.Logger;

import static entities.Container.*;

@ToString
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
    public void deleteDecoration(Decoration decoration)
    {
        for (CakeDecoration cd: cakeDecorationList) {
            if (cd.getCake().equals(this.order) && cd.getDecoration().equals(decoration))
            {
                cakeDecorationList.remove(cd);
                break;
            }
        }
    }
    public void deleteCharacteristic(Characteristic characteristic)
    {
        for (CakeCharacteristic cc : cakeCharacteristicList)
        {
            if (cc.getCharacteristic().equals(characteristic) && cc.getCake().equals(this.order))
            {
                cakeCharacteristicList.remove(cc);
                break;
            }
        }
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
