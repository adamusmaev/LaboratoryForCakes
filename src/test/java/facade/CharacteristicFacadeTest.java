package facade;

import entities.Characteristic;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;
import repositoryimpl.CharacteristicRepositoryImpl;

import static entities.Container.characteristicList;

public class CharacteristicFacadeTest extends TestCase {

    CharacteristicRepositoryImpl characteristicRepository = Mockito.mock(CharacteristicRepositoryImpl.class);
    Characteristic characteristic = new Characteristic("characteristic name", "subscription");
    CharacteristicFacade characteristicFacade = new CharacteristicFacade(characteristic, characteristicRepository);

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
    public void testUpdateCharacteristic()
    {
        characteristicFacade.addCharacteristic();
        characteristicFacade.setCharacteristicName("new characteristic name");
        characteristicFacade.updateCharacteristic();
        assertEquals("new characteristic name",characteristicFacade.getCharacteristicName());
    }

}