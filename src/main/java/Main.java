import decoratorclasses.CakeDecorator;
import entities.*;
import facade.*;
import findbycondition.FindingCakeByBase;
import findbycondition.FindingCakeByDecoration;
import interfaces.Order;
import menu.MainMenu;
import repositoryimpl.*;

import java.util.Scanner;

import static entities.Container.*;

public class Main {
    public static void main(String[] args) {

        MainMenu.showMainMenu();


        /*BaseRepositoryImpl baseRepository = new BaseRepositoryImpl();
        DecorationRepositoryImpl decorationRepository = new DecorationRepositoryImpl();
        CharacteristicRepositoryImpl characteristicRepository = new CharacteristicRepositoryImpl();
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        CakeRepositoryImpl cakeRepository = new CakeRepositoryImpl();

        Base base1 = new Base("base1");
        BaseFacade baseFacade1 = new BaseFacade(base1, baseRepository);

        Decoration decoration1 = new Decoration("decoration1", 10.0F);
        DecorationFacade decorationFacade1 = new DecorationFacade(decoration1, decorationRepository);

        Characteristic characteristic1 = new Characteristic("characteristic1", "subscription");
        CharacteristicFacade characteristicFacade = new CharacteristicFacade(characteristic1, characteristicRepository);

        Customer customer = new Customer("lastname", "firstname");
        CustomerFacade customerFacade = new CustomerFacade(customer, customerRepository);

        Cake cake1 = new Cake("cake1", 10.0F, customer, base1);
        CakeFacade cakeFacade1 = new CakeFacade(cake1, cakeRepository);
        cakeFacade1.addCharacteristic(characteristic1);
        //cakeFacade1.addDecoration(decoration1);
        System.out.println(FindingCakeByDecoration.findCake(decoration1));*/



        /*Base base = new Base("testBase");
        Base base1 = new Base("testBase1");
        Customer customer = new Customer("as", "as");
        Characteristic characteristic = new Characteristic("Characteristic name", "Text Text");
        Decoration decoration = new Decoration("Test Decoration Name", 36.6F);
        Decoration decoration2 = new Decoration("Test Decoration Name number 2", 36.6F);
        Order cake = new Cake("Test Cake Name", 23.0F, customer, base);
        Order order = new CakeDecorator(cake);
        CakeRepositoryImpl cakeRepository = new CakeRepositoryImpl();
        cakeRepository.addCake(cake);
        CustomerRepositoryImpl customerRepository= new CustomerRepositoryImpl();
        //---------------------------------
        order.addDecoration(decoration);
        order.addDecoration(decoration2);
        order.addCharacteristic(characteristic);
        //-------------------------------
        System.out.println(cakeDecorationList.toString());
        order.deleteDecoration(decoration);
        System.out.println(cakeDecorationList.toString());
        System.out.println(cakeCharacteristicList.toString());
        order.deleteCharacteristic(characteristic);
        System.out.println(cakeCharacteristicList.toString());
        //----------------------------------------
        Order cake1 = new Cake("Test Cake Name1", 23.0F, customer, base1);
        Order order1 = new CakeDecorator(cake1);
        cakeRepository.addCake(cake1);
        order1.addDecoration(decoration);
        order1.addDecoration(decoration2);
        //-----------------------------------------
        System.out.println(FindingCakeByDecoration.findCake(decoration,decoration2));
        System.out.println(FindingCakeByDecoration.findCake(decoration));
        //----------------------------
        System.out.println(FindingCakeByBase.findCake(base));


        /*Base base = new Base("testBase");
        Base base1 = new Base("testBase1");
        Customer customer = new Customer("as", "as");
        Characteristic characteristic = new Characteristic("Characteristic name", "Text Text");
        Decoration decoration = new Decoration("Test Decoration Name", 36.6F);
        Decoration decoration2 = new Decoration("Test Decoration Name number 2", 36.6F);
        Order cake = new Cake("Test Cake Name", 23.0F, customer, base);
        Order cake1 = new Cake("Test Cake Name1", 23.0F, customer, base);
        Order cake2 = new Cake("Test Cake Name3", 23.0F, customer, base1);
        Order order = new CakeDecorator(cake);
        Order order1 = new CakeDecorator(cake1);
        order.addCharacteristic(characteristic);
        order.addDecoration(decoration);
        order.addDecoration(decoration2);
        order1.addCharacteristic(characteristic);
        order1.addDecoration(decoration);
        order1.addDecoration(decoration2);
        DecorationCharacteristic.addDecorationCharacteristic(decoration, characteristic);
        CakeRepositoryImpl cakeRepository = new CakeRepositoryImpl();
        cakeRepository.addCake((Cake)cake);
        cakeRepository.addCake((Cake)cake1);
        cakeRepository.addCake((Cake)cake2);
        System.out.println(FindingCakeByDecoration.findCake(decoration, decoration2));*/


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
