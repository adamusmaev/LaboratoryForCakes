package findbycondition;

import entities.Base;
import entities.Cake;
import java.util.ArrayList;
import java.util.List;
import static entities.Container.cakeList;

public class FindCakeByBase {

    public static List<Cake> findCake(Base base)
    {
        List<Cake> cakeListRes = new ArrayList<>();
        for (Cake c: cakeList) {
            if (c.getBase().getUuid() == base.getUuid())
                cakeListRes.add(c);
        }
        return cakeListRes;
    }
}
