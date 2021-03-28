package Facade;

import entities.Characteristic;
import repositoryimpl.CharacteristicRepositoryImpl;

import java.util.UUID;

public class CharacteristicFacade {
    private Characteristic characteristic;
    private CharacteristicRepositoryImpl characteristicRepository;

    public CharacteristicFacade(Characteristic characteristic, CharacteristicRepositoryImpl characteristicRepository)
    {
        this.characteristic = characteristic;
        this.characteristicRepository = characteristicRepository;
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

}
