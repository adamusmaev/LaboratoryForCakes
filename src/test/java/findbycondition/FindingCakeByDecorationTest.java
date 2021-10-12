package findbycondition;

import comporators.SortCake;
import decoratorclasses.CakeDecorator;
import entities.Cake;
import entities.CakeDecoration;
import entities.Decoration;
import interfaces.Order;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.CakeRepositoryImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindingCakeByDecorationTest extends TestCase {

    CakeRepositoryImpl cakeRepository;
    List<CakeDecoration> cakeDecorationList;


    @Before
    public void setUp() throws Exception {
        cakeRepository = Mockito.mock(CakeRepositoryImpl.class);
        cakeDecorationList = new ArrayList<>();
    }

    @Test
    public void testFindCake() {

        Mockito.when(cakeRepository.getAllCakeDecoration()).thenReturn(cakeDecorationList);
        Decoration decoration = new Decoration("Test Decoration Name", 36.6F);
        Decoration decoration2 = new Decoration("Test Decoration Name number 2", 36.6F);
        Cake cake = Mockito.mock(Cake.class);
        Mockito.when(cake.getName()).thenReturn("cake");
        Cake cake1 = Mockito.mock(Cake.class);
        Mockito.when(cake1.getName()).thenReturn("cake1");
        Order order = new CakeDecorator(cake);
        Order order1 = new CakeDecorator(cake1);
        order.addDecoration(decoration);
        cakeDecorationList.add(new CakeDecoration(cake, decoration));
        order.addDecoration(decoration2);
        cakeDecorationList.add(new CakeDecoration(cake, decoration2));
        order1.addDecoration(decoration);
        cakeDecorationList.add(new CakeDecoration(cake1, decoration));
        order1.addDecoration(decoration2);
        cakeDecorationList.add(new CakeDecoration(cake1, decoration2));
        List<Order> cakeListExpectedRes = FindingCakeByDecoration.findCake(cakeRepository.getAllCakeDecoration(),decoration, decoration2);
        List<Cake> cakeListActualResult = new ArrayList<>();
        cakeListActualResult.add((Cake)cake);
        cakeListActualResult.add((Cake)cake1);
        Collections.sort(cakeListActualResult, new SortCake());
        Collections.sort(cakeListExpectedRes, new SortCake());
        assertEquals(cakeListExpectedRes, cakeListActualResult);
    }

    /*Mockito.when(cakeRepository.getAllCakeDecoration()).thenReturn(cakeDecorationList);
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
        List<Order> cakeListExpectedRes = FindingCakeByDecoration.findCake(cakeRepository.getAllCakeDecoration(),decoration, decoration2);
        List<Cake> cakeListActualResult = new ArrayList<>();
        cakeListActualResult.add((Cake)cake);
        cakeListActualResult.add((Cake)cake1);
        Collections.sort(cakeListActualResult, new SortCake());
        Collections.sort(cakeListExpectedRes, new SortCake());
        assertEquals(cakeListExpectedRes, cakeListActualResult);*/
}