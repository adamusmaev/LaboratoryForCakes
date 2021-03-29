package facade;

import entities.Base;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repositoryimpl.BaseRepositoryImpl;

import static entities.Container.baseList;

public class BaseFacadeTest extends TestCase {

    BaseRepositoryImpl baseRepository = new BaseRepositoryImpl();
    Base base = new Base("Test base");
    BaseFacade baseFacade = new BaseFacade(base, baseRepository);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        baseFacade.removeBase();
    }

    @Test
    public void testAddBase() {
        baseFacade.addBase();
        assertEquals(baseFacade.getBase(), base);
    }
    @Test
    public void testRemoveBase() {
        baseFacade.addBase();
        baseFacade.removeBase();
        assertEquals(true, baseList.isEmpty());
    }

    @Test
    public void testUpdateBase() {
        baseFacade.addBase();
        baseFacade.setName("new base name");
        baseFacade.updateBase();
        assertEquals("new base name", baseFacade.getName());
    }
}