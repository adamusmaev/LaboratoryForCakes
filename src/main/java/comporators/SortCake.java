package comporators;

import entities.Cake;

import java.util.Comparator;

public class SortCake implements Comparator<Cake> {

    @Override
    public int compare(Cake o1, Cake o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
