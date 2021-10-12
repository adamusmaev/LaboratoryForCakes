package findbycondition;

import entities.Base;
import entities.Cake;
import entities.Customer;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.CakeRepositoryImpl;

import java.util.HashSet;
import java.util.Set;


public class FindingCakeByBaseTest extends TestCase {

    CakeRepositoryImpl cakeRepository;
    Base base;
    Base base1;
    Customer customer;
    Cake cake;
    Cake cake1;
    Cake cake2;
    Set<Cake> cakeSet = new HashSet<>();
    
    @Before
    public void setUp() {
        cakeRepository = Mockito.mock(CakeRepositoryImpl.class);
        base = new Base("testBase");
        base1 = new Base("testBase1");
        customer = Mockito.mock(Customer.class);
        cake = new Cake("Test Cake Name", 23.0F, customer, base);
        cake1 = new Cake("Test Cake Name1", 23.0F, customer, base);
        cake2 = new Cake("Test Cake Name3", 23.0F, customer, base1);
        cakeSet.add(cake);
        cakeSet.add(cake1);
        cakeSet.add(cake2);
    }
    @Test
    public void testFindCake() {
        Mockito.when(cakeRepository.getAllCakes()).thenReturn(cakeSet);
        Cake cakeTmp = (Cake) FindingCakeByBase.findCake(base1, cakeRepository.getAllCakes()).get(0);
        assertEquals(cake2, cakeTmp);
    }
}

