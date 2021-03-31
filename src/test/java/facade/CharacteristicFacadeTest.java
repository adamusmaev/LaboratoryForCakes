package facade;

import entities.Characteristic;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import repositoryimpl.CharacteristicRepositoryImpl;

import static entities.Container.characteristicList;

public class CharacteristicFacadeTest extends TestCase {
    CharacteristicRepositoryImpl characteristicRepository = new CharacteristicRepositoryImpl();
    Characteristic characteristic = new Characteristic("characteristic name", "subscription");
    CharacteristicFacade characteristicFacade = new CharacteristicFacade(characteristic, characteristicRepository);

    @After
    public void tearDown() throws Exception {
        characteristicFacade.removeCharacteristic();
    }

    @Test
    public void testAddCharacteristic() {
        characteristicFacade.addCharacteristic();
        assertEquals(characteristic, characteristicFacade.getCharacteristic());
    }

    @Test
    public void testRemoveCharacteristic() {
        characteristicFacade.addCharacteristic();
        characteristicFacade.removeCharacteristic();
        assertEquals(true, characteristicList.isEmpty());
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