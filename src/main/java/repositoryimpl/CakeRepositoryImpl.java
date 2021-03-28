package repositoryimpl;

import entities.Base;
import entities.Cake;
import entities.Customer;
import interfaces.Order;
import org.apache.log4j.Logger;

import java.util.UUID;

import static entities.Container.*;

public class CakeRepositoryImpl {
    private final static Logger logger = Logger.getLogger(CakeRepositoryImpl.class);

    public Object getCakeById(UUID uuid)
    {
        for (Cake c: cakeList) {
            if (c.getUuid().equals(uuid))
            {
                return c;
            }
        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }
    public void addCake(Order order)
    {
        Cake cake = (Cake) order;
        Base tmpBase = new Base(cake.getBase());
        baseList.add(tmpBase);
        Customer tmpCustomer = new Customer(cake.getCustomer());
        customerList.add(tmpCustomer);
        Cake tmpCake = new Cake(cake);
        tmpCake.setBase(tmpBase);
        tmpCake.setCustomer(tmpCustomer);
        cakeList.add(tmpCake);
    }
    public void removeCake(Order order)
    {
        Cake cake = (Cake) order;
        for (Cake c: cakeList) {
            if (c.getUuid().equals(cake.getUuid()))
            {
                cakeList.remove(c);
                break;
            }
        }
        logger.info("Delete " + cake.toString() + " in cakeList");
    }
    public void updateCake(Order order)
    {
        Cake cake = (Cake) order;
        for (Cake c: cakeList) {
            if (c.getUuid().equals(cake.getUuid()))
            {
                cakeList.remove(c);
                cakeList.add(cake);
                break;
            }
        }
        logger.info("Update " + cake.toString() + " in cakeList");
    }
}
