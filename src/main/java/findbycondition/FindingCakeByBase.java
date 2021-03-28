package findbycondition;

import entities.Base;
import entities.Cake;
import interfaces.Order;

import java.util.ArrayList;
import java.util.List;
import static entities.Container.cakeList;

public class FindingCakeByBase {

    public static List<Order> findCake(Base base)
    {
        List<Order> cakeListRes = new ArrayList<>();
        for (Cake c: cakeList) {
            if (c.getBase().getUuid() == base.getUuid())
                cakeListRes.add(c);
        }
        return cakeListRes;
    }
}
