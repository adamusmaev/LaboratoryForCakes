package findbycondition;

import comporators.SortCake;
import decoratorclasses.CakeDecorator;
import entities.*;
import interfaces.Order;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import repositoryimpl.CakeRepositoryImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindingCakeByBaseTest extends TestCase {

    @Before
    public void setUp() throws Exception {
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
        //CakeRepositoryImpl cakeRepository= new CakeRepositoryImpl();

    }
}