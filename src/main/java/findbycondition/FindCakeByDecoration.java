package findbycondition;

import entities.Cake;
import entities.CakeDecoration;
import entities.Decoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static entities.Container.cakeDecorationList;

public class FindCakeByDecoration {

    public static List<Cake> findCake(Decoration ... decorations)
    {
        List<Cake> cakeListRes = new ArrayList<>();
        List<Decoration> decorationList = new ArrayList<>();
        List<CakeDecoration> cakeDecorations = new ArrayList<>();
        decorationList = Arrays.asList(decorations);
        for (CakeDecoration cd : cakeDecorationList)
        {

        }
        return null;
    }
}
