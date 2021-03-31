package facade;

import entities.Decoration;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import repositoryimpl.DecorationRepositoryImpl;

import static entities.Container.decorationList;

public class DecorationFacadeTest extends TestCase {

    DecorationRepositoryImpl decorationRepository = new DecorationRepositoryImpl();
    DecorationFacade decorationFacade;
    Decoration decoration;

    @Before
    public void setUp() throws Exception {
        decoration = new Decoration("decoration name", 3F);
        decorationFacade = new DecorationFacade(decoration, decorationRepository);
    }

    public void tearDown() throws Exception {

    }

    @Test
    public void testAddDecoration() {
        decorationFacade.addDecoration();
        assertEquals(decoration, decorationFacade.getDecoration());
    }

    @Test
    public void testRemoveDecoration() {
        decorationFacade.addDecoration();
        decorationFacade.removeDecoration();
        assertEquals(true, decorationList.isEmpty());
    }

    @Test
    public void testUpdateDecoration() {
        decorationFacade.addDecoration();
        decorationFacade.setDecorationPrise(5F);
        assertEquals(5F, decorationFacade.getDecorationPrice());
    }
}