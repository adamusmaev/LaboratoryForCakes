package repositoryimpl;

import entities.Characteristic;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static entities.Container.characteristicList;

public class CharacteristicRepositoryImplTest extends TestCase {

    CharacteristicRepositoryImpl characteristicRepository;
    Characteristic characteristic;

    @Before
    public void setUp() {
        characteristic = new Characteristic("ch", "ch");
        characteristicRepository = new CharacteristicRepositoryImpl();
        characteristicRepository.addCharacteristic(characteristic);
    }

    @After
    public void tearDown() {
        characteristicList.clear();
    }

    @Test
    public void testGetCharacteristicById() {
        characteristicRepository.addCharacteristic(characteristic);
        assertEquals(characteristic, characteristicRepository.getCharacteristicById(characteristic.getUuid()));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testRemoveCharacteristic() {
        characteristicRepository.removeCharacteristic(characteristic);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("This id: " + characteristic.getUuid() + " not found");
        //characteristicRepository.getCharacteristicById(characteristic.getUuid());
    }

    @Test
    public void testUpdateCharacteristic() {
        characteristic.setName("new Name");
        characteristicRepository.updateCharacteristic(characteristic);
        assertEquals(characteristic, characteristicRepository.getCharacteristicById(characteristic.getUuid()));
    }
}