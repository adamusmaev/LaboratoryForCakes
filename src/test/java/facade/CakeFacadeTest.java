package facade;

import entities.*;
import findbycondition.FindingCakeByDecoration;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repositoryimpl.CakeRepositoryImpl;

public class CakeFacadeTest extends TestCase {

    CakeRepositoryImpl cakeRepository = new CakeRepositoryImpl();
    Base base = new Base("testBase");
    Base base1 = new Base("testBase1");
    Customer customer = new Customer("as", "as");
    Characteristic characteristic = new Characteristic("Characteristic name", "Text Text");
    Decoration decoration = new Decoration("Test Decoration Name", 36.6F);
    Decoration decoration2 = new Decoration("Test Decoration Name number 2", 36.6F);
    Cake cake;
    CakeFacade cakeFacade;

    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown()
    {
    }


    @Test
    public void testAddCake()
    {
        Cake cake = new Cake("Test Cake Name", 23.0F, customer, base);
        cakeFacade = new CakeFacade(cake, cakeRepository);
        cakeFacade.addCake();
        assertEquals(cake,cakeFacade.getCake());
    }

    @Test
    public void testAddDecoration()
    {
        Cake cake = new Cake("Test Cake Name", 23.0F, customer, base);
        cakeFacade = new CakeFacade(cake, cakeRepository);
        cakeFacade.addDecoration(decoration);
        cakeFacade.addCake();
        assertEquals(cake, FindingCakeByDecoration.findCake(decoration).get(0));

    }
}