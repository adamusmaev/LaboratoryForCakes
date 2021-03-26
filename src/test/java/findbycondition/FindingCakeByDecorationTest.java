package findbycondition;

import comporators.SortCake;
import decoratorclasses.CakeDecorator;
import entities.*;
import interfaces.Order;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindingCakeByDecorationTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testFindCake() {
        Base base = new Base("testBase");
        Base base1 = new Base("testBase1");
        Customer customer = new Customer("as", "as");
        Characteristic characteristic = new Characteristic("Characteristic name", "Text Text");
        Decoration decoration = new Decoration("Test Decoration Name", 36.6F);
        Decoration decoration2 = new Decoration("Test Decoration Name number 2", 36.6F);
        Order cake = new Cake("Test Cake Name", 23.0F, customer, base);
        Order cake1 = new Cake("Test Cake Name1", 23.0F, customer, base);
        Order cake2 = new Cake("Test Cake Name3", 23.0F, customer, base1);
        Order order = new CakeDecorator(cake);
        Order order1 = new CakeDecorator(cake1);
        order.addDecoration(decoration);
        order.addDecoration(decoration2);
        order1.addDecoration(decoration);
        order1.addDecoration(decoration2);
        List<Cake> cakeListExpectedRes = FindingCakeByDecoration.findCake(decoration, decoration2);
        List<Cake> cakeListActualResult = new ArrayList<>();
        cakeListActualResult.add((Cake)cake);
        cakeListActualResult.add((Cake)cake1);
        Collections.sort(cakeListActualResult, new SortCake());
        Collections.sort(cakeListExpectedRes, new SortCake());
        assertEquals(cakeListExpectedRes, cakeListActualResult);
    }
}