package facade;

import entities.Characteristic;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.CharacteristicRepositoryImpl;

public class CharacteristicFacadeTest extends TestCase {

    CharacteristicRepositoryImpl characteristicRepository;
    Characteristic characteristic;
    CharacteristicFacade characteristicFacade;

    @Before
    public void setUp() {
        characteristicRepository = Mockito.mock(CharacteristicRepositoryImpl.class);
        characteristic = new Characteristic("characteristic name", "subscription");
        characteristicFacade = new CharacteristicFacade(characteristic, characteristicRepository);
    }

    @After
    public void tearDown() {
        characteristicFacade.removeCharacteristic();
    }

    @Test
    public void testAddCharacteristic() {
        characteristicFacade.addCharacteristic();
        assertEquals(characteristic, characteristicFacade.getCharacteristic());
    }

    @Test
    public void testUpdateCharacteristic() {
        characteristicFacade.addCharacteristic();
        characteristicFacade.setCharacteristicName("new characteristic name");
        characteristicFacade.updateCharacteristic();
        assertEquals("new characteristic name", characteristicFacade.getCharacteristicName());
    }

}