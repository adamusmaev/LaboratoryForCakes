package repositoryImpl;

import entities.Characteristic;
import org.apache.log4j.Logger;

import java.util.UUID;

import static entities.Container.cakeList;
import static entities.Container.characteristicList;

public class CharacteristicRepositoryImpl {
    private final static Logger logger = Logger.getLogger(BaseRepositoryImpl.class);

    public Object getCharacteristicById(UUID uuid)
    {
        for (int i = 0; i < characteristicList.size(); i++)
        {
            if(uuid == characteristicList.get(i).getUuid())
            {
                return characteristicList.get(i);
            }
        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }
    public void addCharacteristic(Characteristic characteristic)
    {
        characteristicList.add(characteristic);
    }
    public void removeCharacteristic(Characteristic characteristic)
    {
        for (int i = 0; i < characteristicList.size(); i++)
        {
            if (characteristic.equals(characteristicList.get(i)))
            {
                characteristicList.remove(i);
                break;
            }
        }
    }
    public void updateCharacteristic(Characteristic characteristic)
    {
        for (int i = 0; i < characteristicList.size(); i++)
        {
            if (characteristic.equals(characteristicList.get(i)))
            {
                characteristicList.set(i, characteristic);
                break;
            }
        }
    }

}
