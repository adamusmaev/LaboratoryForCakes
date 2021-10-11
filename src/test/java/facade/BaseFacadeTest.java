package facade;

import entities.Base;
import entities.Decoration;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.BaseRepositoryImpl;

import static entities.Container.baseList;

public class BaseFacadeTest extends TestCase {

    BaseRepositoryImpl baseRepository =  Mockito.mock(BaseRepositoryImpl.class);
    Base base = new Base("base name");
    BaseFacade baseFacade = new BaseFacade(base, baseRepository);

    @Before
    public void setUp() {
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