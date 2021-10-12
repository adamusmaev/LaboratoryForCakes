package facade;

import entities.Decoration;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.DecorationRepositoryImpl;

import static entities.Container.decorationList;

public class DecorationFacadeTest extends TestCase {

    DecorationRepositoryImpl decorationRepository;
    DecorationFacade decorationFacade;
    Decoration decoration;
    Decoration decorationMockito;

    @Before
    public void setUp() {
        decorationRepository = Mockito.mock(DecorationRepositoryImpl.class);
        decoration = new Decoration("decoration name", 3F);
        decorationMockito = Mockito.spy(decoration);
        decorationFacade = new DecorationFacade(decorationMockito, decorationRepository);
    }


    @Test
    public void testAddDecoration() {
        decorationFacade.addDecoration();
        assertEquals(decorationMockito, decorationFacade.getDecoration());
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