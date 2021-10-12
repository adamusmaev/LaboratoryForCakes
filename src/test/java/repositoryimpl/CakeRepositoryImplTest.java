package repositoryimpl;

import entities.Base;
import entities.Cake;
import entities.Customer;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static entities.Container.cakeList;

public class CakeRepositoryImplTest extends TestCase {

    CakeRepositoryImpl cakeRepository;
    Cake cake;

    @Before
    public void setUp(){
        cakeRepository = new CakeRepositoryImpl();
        Base base = new Base("base name");
        Customer customer = new Customer("name", "name");
        cake = new Cake("cake name", 11F, customer, base );
        cakeRepository.addCake(cake);
    }

    @After
    public void tearDown() {
        cakeList.clear();

    }
    @Test
    public void testGetCakeById() {
        assertEquals(cake, cakeRepository.getCakeById(cake.getUuid()));
    }

    @Test
    public void testRemoveCake() {
        cakeRepository.removeCake(cake);
        assertFalse(cakeList.contains(cake));
    }

    @Test
    public void testUpdateCake() {
        cake.setName("new cake name");
        cakeRepository.updateCake(cake);
        assertEquals(cake, cakeRepository.getCakeById(cake.getUuid()));
    }
}