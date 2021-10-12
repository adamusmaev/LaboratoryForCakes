package facade;

import entities.Base;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.BaseRepositoryImpl;

public class BaseFacadeTest extends TestCase {

    BaseRepositoryImpl baseRepository;
    Base base;
    BaseFacade baseFacade;


    @Before
    public void setUp() {
        baseRepository = Mockito.mock(BaseRepositoryImpl.class);
        base = new Base("base name");
        baseFacade = new BaseFacade(base, baseRepository);
    }

    @After
    public void tearDown() {
        baseFacade.removeBase();
    }

    @Test
    public void testAddBase() {
        baseFacade.addBase();
        System.out.println(baseFacade.getBase());
        assertEquals(baseFacade.getBase(), base);
    }

    @Test
    public void testUpdateBase() {
        baseFacade.addBase();
        baseFacade.setName("new base name");
        baseFacade.updateBase();
        assertEquals("new base name", baseFacade.getName());
    }
}