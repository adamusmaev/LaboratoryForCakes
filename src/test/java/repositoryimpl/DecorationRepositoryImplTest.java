package repositoryimpl;

import entities.Decoration;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static entities.Container.decorationList;

public class DecorationRepositoryImplTest extends TestCase {

    DecorationRepositoryImpl decorationRepository;
    Decoration decoration;

    @Before
    public void setUp() {
        decorationRepository = new DecorationRepositoryImpl();
        decoration = new Decoration("name", 12F);
        decorationRepository.addDecoration(decoration);
    }

    @After
    public void tearDown() {
        decorationList.clear();
    }

    @Test
    public void testGetDecorationById() {
        assertEquals(decoration, decorationRepository.getDecorationById(decoration.getUuid()));
    }

    @Test
    public void testRemoveDecoration() {
        decorationRepository.removeDecoration(decoration);
        assertFalse(decorationList.contains(decoration));
    }

    public void testUpdateDecoration() {
        decoration.setName("new decoration name");
        decorationRepository.updateDecoration(decoration);
        assertEquals(decoration, decorationRepository.getDecorationById(decoration.getUuid()));
    }
}