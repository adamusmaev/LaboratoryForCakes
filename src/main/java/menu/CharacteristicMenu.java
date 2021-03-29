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
            System.out.println("Find characteristic by name: 4");
            System.out.println("Show main menu: 5");
            int number = in.nextInt();
            if (number == 1)
            {
                Scanner inCharacteristic = new Scanner(System.in);
                System.out.println("Enter the characteristic name:");
                String characteristicName = inCharacteristic.nextLine();
                if (characteristicName.isEmpty())
                {
                    System.out.println("Enter correctly characteristic name\n");
                    continue;
                }
                Scanner inCharacteristicSubscription = new Scanner(System.in);
                System.out.println("Enter the characteristic subscription:");
                String characteristicSubscription = inCharacteristicSubscription.nextLine();
                if (characteristicSubscription.isEmpty())
                {
                    System.out.println("Enter correctly characteristic subscription");
                    continue;
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
                CharacteristicFacade characteristicFacade = CharacteristicFacade.getCharacteristicFacade(UUID.fromString(characteristicID));
                characteristicFacade.removeCharacteristic();
            }
            if (number == 3)
            {
                Scanner inCharacteristicID = new Scanner(System.in);
                System.out.println("Enter id");
                String characteristicID = inCharacteristicID.nextLine();
                Scanner inCharacteristicName = new Scanner(System.in);
                System.out.println("Enter a new characteristic name");
                String characteristicName = inCharacteristicName.nextLine();
                Scanner inCharacteristicSubscription = new Scanner(System.in);
                System.out.println("Enter a new characteristic subscription");
                String characteristicSubscription = inCharacteristicSubscription.nextLine();
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
                else
                {
                    CharacteristicFacade characteristicFacade = CharacteristicFacade.getCharacteristicFacade(UUID.fromString(characteristicID));
                    System.out.println(characteristicFacade.getCharacteristic());
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
