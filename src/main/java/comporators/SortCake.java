package comporators;

import entities.Cake;
import interfaces.Order;

import java.util.Comparator;

public class SortCake implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
