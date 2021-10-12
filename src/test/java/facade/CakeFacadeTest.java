package facade;

import entities.Base;
import entities.Cake;
import entities.Customer;
import entities.Decoration;
import findbycondition.FindingCakeByDecoration;
import interfaces.Order;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.CakeRepositoryImpl;

import java.util.UUID;

import static entities.Container.cakeDecorationList;

public class CakeFacadeTest extends TestCase {

    CakeRepositoryImpl cakeRepository;
    Base base;
    Customer customer;
    Decoration decoration;
    CakeFacade cakeFacade;
    Cake cake;


    @Before
    public void setUp() {
        cakeRepository = Mockito.mock(CakeRepositoryImpl.class);
        base = new Base("testBase");
        customer = new Customer("as", "as");
        decoration = new Decoration("Test Decoration Name", 36.6F);
        cake = new Cake("Test Cake Name", 23.0F, customer, base);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testAddCake() {
        cakeFacade = new CakeFacade(cake, cakeRepository);
        cakeFacade.addCake();
        assertEquals(cake, cakeFacade.getCake());
    }

    @Test
    public void testAddCakeMockito() {
        cake = Mockito.mock(Cake.class);
        CakeFacade cakeFacade = Mockito.mock(CakeFacade.class);
        Mockito.when(cakeFacade.getCake()).thenReturn(cake);
        assertEquals(cake, cakeFacade.getCake());
    }

    @Test
    public void testAddDecoration() {
        cakeFacade = new CakeFacade(cake, cakeRepository);
        cakeFacade.addDecoration(decoration);
        cakeFacade.addCake();
        Mockito.when(cakeRepository.getAllCakeDecoration()).thenReturn(cakeDecorationList);
        assertEquals(cake, FindingCakeByDecoration.findCake(cakeRepository.getAllCakeDecoration(), decoration).get(0));
    }

    @Test
    public void testMockitoCake() {
        cake = Mockito.mock(Cake.class);
        Mockito.when(cake.getBase()).thenReturn(new Base("nameqwqwq"));
    }

    @Test
    public void testMockitoCakeRepositoryIMPL() {

        CakeRepositoryImpl cakeRepository = Mockito.mock(CakeRepositoryImpl.class);
        Order cake = Mockito.mock(Cake.class);
        Mockito.when(cakeRepository.getCakeById(Mockito.any())).thenReturn(cake);
        System.out.println(cakeRepository.getCakeById(UUID.randomUUID()));

        UUID uuid = UUID.fromString("0c9868e3-ea92-4d44-ab56-8fe9d29b6035");
        Mockito.when(cakeRepository.getCakeById(uuid)).thenReturn("new Cake");
        System.out.println(cakeRepository.getCakeById(uuid));

        UUID uuid2 = UUID.fromString("0c9868e3-ea92-4d44-ab56-8fe9d29b6036");
        //Mockito.when(cakeRepository.getCakeById(uuid2)).thenThrow(new Exception("Invalid UUID"));
        //System.out.println(cakeRepository.getCakeById(uuid));

        Mockito.doNothing().when(cakeRepository).removeCake(cake);

        //verify(cakeRepository, Mockito.times(2)).removeCake(cake);
    }
}