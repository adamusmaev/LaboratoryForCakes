import decoratorclasses.CakeDecorator;
import entities.*;
import interfaces.Order;
import repositoryimpl.*;

import static entities.Container.*;

public class Main {
    public static void main(String[] args) {
        Base base = new Base("testBase");
        Customer customer = new Customer("as", "as");
        Characteristic characteristic = new Characteristic("Characteristic name", "Text Text");
        Decoration decoration = new Decoration("Test Decoration Name", 36.6F);
        Decoration decoration2 = new Decoration("Test Decoration Name number 2", 36.6F);
        Cake cake = new Cake("Test Cake Name", 23.0F, customer, base);
        Order order = new CakeDecorator(cake);
        order.addCharacteristic(characteristic);
        order.addDecoration(decoration);
        order.addDecoration(decoration2);


        /*Base base = new Base("testBase");
        BaseRepositoryImpl baseRepository = new BaseRepositoryImpl();
        baseRepository.addBase(base);
        base.setName("Number 2");
        System.out.println(base.getUuid());
        System.out.println(base.toString());
        System.out.println(baseList.toString());
        baseRepository.updateBase(base);
        System.out.println(base.toString());
        System.out.println(baseList.toString());
        baseRepository.deleteBase(base);
        System.out.println(base.toString());
        System.out.println(baseList.toString());

        Customer customer = new Customer("as", "as");
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        customerRepository.addCustomer(customer);
        customer.setFirstName("test");
        System.out.println(customer.toString());
        System.out.println(customerList.toString());
        customerRepository.getCustomerById(customer.getUuid());
        customerRepository.update(customer);
        System.out.println(customer.toString());
        System.out.println(customerList.toString());
        customerRepository.removeCustomer(customer);
        System.out.println(customer.toString());
        System.out.println(customerList.toString());

        Characteristic characteristic = new Characteristic("Characteristic name", "Text Text");
        CharacteristicRepositoryImpl characteristicRepository = new CharacteristicRepositoryImpl();
        characteristicRepository.addCharacteristic(characteristic);
        characteristicRepository.getCharacteristicById(characteristic.getUuid());
        characteristic.setName("Number 2 name");
        System.out.println(characteristic.toString());
        System.out.println(characteristicList.toString());
        characteristicRepository.updateCharacteristic(characteristic);
        System.out.println(characteristic.toString());
        System.out.println(characteristicList.toString());
        characteristicRepository.removeCharacteristic(characteristic);
        System.out.println(characteristic.toString());
        System.out.println(characteristicList.toString());

        Decoration decoration = new Decoration("Test Decoration Name", 36.6F);
        DecorationRepositoryImpl decorationRepository = new DecorationRepositoryImpl();
        decorationRepository.addDecoration(decoration);
        decorationRepository.getDecorationById(decoration.getUuid());
        decoration.setName("Number 2 name");
        System.out.println(decoration.toString());
        System.out.println(decorationList.toString());
        decorationRepository.updateDecoration(decoration);
        System.out.println(decoration.toString());
        System.out.println(decorationList.toString());
        decorationRepository.removeDecoration(decoration);
        System.out.println(decoration.toString());
        System.out.println(decorationList.toString());

        Cake cake = new Cake("Test Cake Name", 23.0F, customer, base);
        CakeRepositoryImpl cakeRepository = new CakeRepositoryImpl();
        cakeRepository.addCake(cake);
        cake.setName("Number 2 name");
        System.out.println(cake.toString());
        System.out.println(cakeList.toString());
        cakeRepository.getCakeById(cake.getUuid());
        cakeRepository.updateCake(cake);
        System.out.println(cake.toString());
        System.out.println(cakeList.toString());
        cakeRepository.removeCake(cake);
        System.out.println(cake.toString());
        System.out.println(cakeList.toString());*/
    }
}
