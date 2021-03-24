package comporators;

import entities.Decoration;

import java.util.Comparator;

public class SortDecoration implements Comparator<Decoration> {

    @Override
    public int compare(Decoration o1, Decoration o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
