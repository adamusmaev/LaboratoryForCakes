package menu;

import entities.Characteristic;
import facade.CharacteristicFacade;
import facade.CustomerFacade;
import repositoryimpl.CakeRepositoryImpl;
import repositoryimpl.CharacteristicRepositoryImpl;

import java.util.Scanner;
import java.util.UUID;

import static entities.Container.characteristicList;

public class CharacteristicMenu {
    public static void showCharacteristicMenu()
    {
        CharacteristicRepositoryImpl characteristicRepository = new CharacteristicRepositoryImpl();
        while (true)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Add new characteristic: 1");
            System.out.println("Remove characteristic: 2");
            System.out.println("Update characteristic: 3");
            System.out.println("Find characteristic by ID: 4");
            System.out.println("Show main menu: 5");
            int number = in.nextInt();
            if (number == 1)
            {
                Scanner inCharacteristic = new Scanner(System.in);
                System.out.println("Enter the characteristic name:");
                String characteristicName = inCharacteristic.nextLine();
                while (true) {
                    if (characteristicName.isEmpty()) {
                        System.out.println("Enter correctly characteristic name\n");
                        inCharacteristic = new Scanner(System.in);
                        characteristicName = inCharacteristic.nextLine();
                        continue;
                    }
                    break;
                }
                Scanner inCharacteristicSubscription = new Scanner(System.in);
                System.out.println("Enter the characteristic subscription:");
                String characteristicSubscription = inCharacteristicSubscription.nextLine();
                while (true) {
                    if (characteristicSubscription.isEmpty()) {
                        System.out.println("Enter correctly subscription\n");
                        inCharacteristicSubscription = new Scanner(System.in);
                        characteristicSubscription = inCharacteristicSubscription.nextLine();
                        continue;
                    }
                    break;
                }
                Characteristic characteristic = new Characteristic(characteristicName, characteristicSubscription);
                CharacteristicFacade characteristicFacade = new CharacteristicFacade(characteristic, characteristicRepository);
                characteristicFacade.addCharacteristic();
            }
            if (number == 2)
            {
                Scanner inCharacteristicID = new Scanner(System.in);
                System.out.println("Enter id");
                String characteristicID = inCharacteristicID.nextLine();
                try
                {
                    CharacteristicFacade characteristicFacade = CharacteristicFacade.getCharacteristicFacade(UUID.fromString(characteristicID));
                    characteristicFacade.removeCharacteristic();
                }
                catch (IllegalArgumentException ex)
                {
                    System.out.println("ID not found");
                    continue;
                }
            }
            if (number == 3)
            {
                Scanner inCharacteristicID = new Scanner(System.in);
                System.out.println("Enter id");
                String characteristicID = inCharacteristicID.nextLine();
                try
                {
                    CharacteristicFacade characteristicFacade = CharacteristicFacade.getCharacteristicFacade(UUID.fromString(characteristicID));
                    characteristicFacade.removeCharacteristic();
                }
                catch (IllegalArgumentException ex)
                {
                    System.out.println("ID not found");
                    continue;
                }
                Scanner inCharacteristicName = new Scanner(System.in);
                System.out.println("Enter a new characteristic name");
                String characteristicName = inCharacteristicName.nextLine();
                while (true) {
                    if (characteristicName.isEmpty()) {
                        System.out.println("Enter correctly characteristic name\n");
                        inCharacteristicName = new Scanner(System.in);
                        characteristicName = inCharacteristicName.nextLine();
                        continue;
                    }
                    break;
                }
                Scanner inCharacteristicSubscription = new Scanner(System.in);
                System.out.println("Enter a new characteristic subscription");
                String characteristicSubscription = inCharacteristicSubscription.nextLine();
                while (true) {
                    if (characteristicSubscription.isEmpty()) {
                        System.out.println("Enter correctly csubscription\n");
                        inCharacteristicSubscription = new Scanner(System.in);
                        characteristicSubscription = inCharacteristicSubscription.nextLine();
                        continue;
                    }
                    break;
                }
                CharacteristicFacade characteristicFacade = CharacteristicFacade.getCharacteristicFacade(UUID.fromString(characteristicID));
                characteristicFacade.setCharacteristicName(characteristicName);
                characteristicFacade.setCharacteristicSubscription(characteristicSubscription);
                characteristicFacade.updateCharacteristic();
            }
            if (number == 4)
            {
                Scanner inCharacteristicID = new Scanner(System.in);
                System.out.println("Enter id");
                String characteristicID = inCharacteristicID.nextLine();
                if (characteristicID.isEmpty())
                {
                    System.out.println(characteristicList);
                }
                try {
                    CharacteristicFacade characteristicFacade = CharacteristicFacade.getCharacteristicFacade(UUID.fromString(characteristicID));
                    System.out.println(characteristicFacade.getCharacteristic().toString());
                }
                catch (IllegalArgumentException ex)
                {
                    System.out.println("Id not found");
                    System.out.println(characteristicList);
                }
            }
            if (number == 5) exit();
        }
    }
    public static void exit()
    {
        MainMenu.showMainMenu();
    }
}
