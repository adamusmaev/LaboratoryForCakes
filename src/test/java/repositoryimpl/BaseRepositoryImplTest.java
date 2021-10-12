package repositoryimpl;

import entities.Base;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static entities.Container.baseList;

public class BaseRepositoryImplTest extends TestCase {

    BaseRepositoryImpl baseRepository;
    Base base;

    @Before
    public void setUp() {
        baseRepository = new BaseRepositoryImpl();
        base = new Base("base");
        baseRepository.addBase(base);
    }

    @After
    public void tearDown() {
        baseList.clear();
    }

    @Test
    public void testGetBaseById() {
        assertEquals(base, baseRepository.getBaseById(base.getUuid()));
    }

    @Test
    public void testDeleteBase() {
        baseRepository.deleteBase(base);
        baseRepository.getBaseById(base.getUuid());
        assertFalse(baseList.contains(base));

    }

    @Test
    public void testUpdateBase() {
        base.setName("new base name");
        baseRepository.updateBase(base);
        assertEquals(base, baseRepository.getBaseById(base.getUuid()));
    }
}