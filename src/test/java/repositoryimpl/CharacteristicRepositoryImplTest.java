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
    }
    @After
    public void tearDown(){
        characteristicList.clear();
    }

    @Test
    public void testGetCharacteristicById() {
        characteristicRepository.addCharacteristic(characteristic);
        assertEquals(characteristic, characteristicRepository.getCharacteristicById(characteristic.getUuid()));
    }

}