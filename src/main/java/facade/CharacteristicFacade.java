package facade;

import entities.Characteristic;
import lombok.Getter;
import repositoryimpl.CharacteristicRepositoryImpl;

import java.util.UUID;

import static entities.Container.characteristicFacadeList;

public class CharacteristicFacade {
    @Getter
    private Characteristic characteristic;
    private CharacteristicRepositoryImpl characteristicRepository;

    public CharacteristicFacade(Characteristic characteristic, CharacteristicRepositoryImpl characteristicRepository)
    {
        this.characteristic = characteristic;
        this.characteristicRepository = characteristicRepository;
        characteristicFacadeList.add(this);
    }

    public Object getCharacteristicById (UUID uuid)
    {
        return characteristicRepository.getCharacteristicById(uuid);
    }
    public void addCharacteristic()
    {
        characteristicRepository.addCharacteristic(characteristic);
    }
    public void removeCharacteristic()
    {
        characteristicRepository.removeCharacteristic(characteristic);
    }
    public void updateCharacteristic()
    {
        characteristicRepository.updateCharacteristic(characteristic);
    }
    public String getCharacteristicName()
    {
        return characteristic.getName();
    }
    public void setCharacteristicName(String name)
    {
        characteristic.setName(name);
    }
    public String getCharacteristicSubscription()
    {
        return characteristic.getSubscription();
    }
    public void setCharacteristicSubscription(String subscription)
    {
        characteristic.setSubscription(subscription);
    }
    public static  CharacteristicFacade getCharacteristicFacade(UUID uuid)
    {
        for (CharacteristicFacade cf : characteristicFacadeList)
        {
            if(cf.characteristic.getUuid().equals(uuid))
            {
                return cf;
            }
        }
        throw new IllegalArgumentException();
    }
}
