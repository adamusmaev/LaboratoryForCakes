package findbycondition;

import entities.Base;
import entities.Cake;
import interfaces.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FindingCakeByBase {

    public static List<Order> findCake(Base base, Set<Cake> cakeList) {
        List<Order> cakeListRes = new ArrayList<>();
        for (Cake c : cakeList) {
            if (c.getBase().getUuid() == base.getUuid())
                cakeListRes.add(c);
        }
        return cakeListRes;
    }
}
