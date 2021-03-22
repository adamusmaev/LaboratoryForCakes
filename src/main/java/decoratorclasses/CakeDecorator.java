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
}
