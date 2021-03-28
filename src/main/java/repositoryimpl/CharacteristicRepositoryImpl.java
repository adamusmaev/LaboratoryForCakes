package repositoryimpl;

import entities.Characteristic;
import org.apache.log4j.Logger;

import java.util.UUID;

import static entities.Container.characteristicList;
import static entities.Container.customerList;

public class CharacteristicRepositoryImpl {
    private final static Logger logger = Logger.getLogger(CharacteristicRepositoryImpl.class);

    public Object getCharacteristicById(UUID uuid)
    {
        for (Characteristic c: characteristicList) {
            if (c.getUuid().equals(uuid))
            {
                return c;
            }
        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }
    public void addCharacteristic(Characteristic characteristic)
    {
        characteristicList.add(new Characteristic(characteristic));
        logger.info("Add " + characteristic.toString() + " in characteristicList");
    }
    public void removeCharacteristic(Characteristic characteristic)
    {
        for (Characteristic c : characteristicList)
        {
            if(characteristic.getUuid().equals(c.getUuid()))
            {
                characteristicList.remove(c);
                break;
            }
        }
        logger.info("Delete " + characteristic.toString() + " in characteristicList");
    }
    public void updateCharacteristic(Characteristic characteristic)
    {
        for (Characteristic c : characteristicList)
        {
            if(characteristic.getUuid().equals(c.getUuid()))
            {
                characteristicList.remove(c);
                characteristicList.add(characteristic);
                break;
            }
        }
        logger.info("Update " + characteristic.toString() + " in characteristicList");
    }
}
