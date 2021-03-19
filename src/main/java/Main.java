import entities.*;
import repositoryImpl.*;

import java.util.UUID;

import static entities.Container.baseList;
import static entities.Container.cakeList;

public class Main {
    public static void main(String[] args) {

        Base base = new Base("testBase");
        BaseRepositoryImpl baseRepository = new BaseRepositoryImpl();
        baseRepository.addBase(base);
        baseRepository.updateBase(base);
        baseRepository.deleteBase(base);

        Customer customer = new Customer("as", "as");
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        customerRepository.addCustomer(customer);
        customerRepository.getCustomerById(customer.getUuid());
        customerRepository.update(customer);
        customerRepository.removeCustomer(customer);

        Decoration decoration = new Decoration("Test Decoration Name", 36.6F);
        DecorationRepositoryImpl decorationRepository = new DecorationRepositoryImpl();
        decorationRepository.addDecoration(decoration);
        decorationRepository.getDecorationById(decoration.getUuid());
        decorationRepository.updateDecoration(decoration);
        decorationRepository.removeDecoration(decoration);

        Cake cake = new Cake("Test Cake Name", 23.0F, customer, base);
        CakeRepositoryImpl cakeRepository = new CakeRepositoryImpl();
        cakeRepository.addCake(cake);
        cakeRepository.getCakeById(cake.getUuid());
        cakeRepository.updateCake(cake);
        cakeRepository.removeCake(cake);

        Characteristic characteristic = new Characteristic("Characteristic name", "Text Text");
        CharacteristicRepositoryImpl characteristicRepository = new CharacteristicRepositoryImpl();
        characteristicRepository.addCharacteristic(characteristic);
        characteristicRepository.getCharacteristicById(characteristic.getUuid());
        characteristicRepository.updateCharacteristic(characteristic);
        characteristicRepository.removeCharacteristic(characteristic);

    }
}
