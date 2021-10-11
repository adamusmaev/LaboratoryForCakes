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

    CakeRepositoryImpl cakeRepository = Mockito.mock(CakeRepositoryImpl.class);
    Base base = new Base("testBase");
    Base base1 = new Base("testBase1");
    Customer customer = Mockito.mock(Customer.class);
    Cake cake = new Cake("Test Cake Name", 23.0F, customer, base);
    Cake cake1 = new Cake("Test Cake Name1", 23.0F, customer, base);
    Cake cake2 = new Cake("Test Cake Name3", 23.0F, customer, base1);
    Set<Cake> cakeSet = new HashSet<>();
    
    @Before
    public void setUp() {
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

