package findbycondition;

import comporators.SortDecoration;
import entities.Cake;
import entities.CakeDecoration;
import entities.Decoration;

import java.util.*;

import static entities.Container.cakeDecorationList;
import static entities.Container.cakeList;

public class FindingCakeByDecoration {

    public static List<Cake> findCake(Decoration ... decorations)
    {
        List<Cake> cakeListRes = new ArrayList<>();
        List<Decoration> decorationList;
        decorationList = Arrays.asList(decorations);
        Collections.sort(decorationList, new SortDecoration());
        Map<Cake, List<Decoration>> map= new HashMap<>();
        for (CakeDecoration cd : cakeDecorationList)
        {
            if (!map.containsKey(cd.getCake()))
            {
            List<Decoration> list = new ArrayList<>();
            list.add(cd.getDecoration());
            map.put(cd.getCake(), list);
            }
            else
            {
                List<Decoration> tmpList = map.get(cd.getCake());
                tmpList.add(cd.getDecoration());
            }
        }
        for (Map.Entry<Cake, List<Decoration>> m : map.entrySet())
        {
            List<Decoration> listTmp = new ArrayList<>();
            listTmp = m.getValue();
            Collections.sort(listTmp, new SortDecoration());
            if (listTmp.equals(decorationList)) cakeListRes.add(m.getKey());
        }
        return cakeListRes;
    }
}
