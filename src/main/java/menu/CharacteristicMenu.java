package menu;

import entities.Characteristic;
import facade.CharacteristicFacade;
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
            MainMenu.printMenu("Characteristic");
            int number = in.nextInt();
            if (number == 1)
            {
                String characteristicName = MainMenu.readUserMessage("Enter the characteristic name:");
                while (true) {
                    if (characteristicName.isEmpty()) {
                        characteristicName = MainMenu.readUserMessage("Enter correctly characteristic name\n");
                        continue;
                    }
                    break;
                }
                String characteristicSubscription = MainMenu.readUserMessage("Enter the characteristic subscription:");
                while (true) {
                    if (characteristicSubscription.isEmpty()) {
                        characteristicSubscription = MainMenu.readUserMessage("Enter correctly subscription\n");
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
                String characteristicID = MainMenu.readUserMessage("Enter id");
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
                String characteristicID = MainMenu.readUserMessage("Enter id");
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

                String characteristicName = MainMenu.readUserMessage("Enter a new characteristic name");
                while (true) {
                    if (characteristicName.isEmpty()) {
                        characteristicName = MainMenu.readUserMessage("Enter correctly characteristic name\n");
                        continue;
                    }
                    break;
                }
                String characteristicSubscription = MainMenu.readUserMessage("Enter a new characteristic subscription");
                while (true) {
                    if (characteristicSubscription.isEmpty()) {
                        characteristicSubscription = MainMenu.readUserMessage("Enter correctly subscription\n");
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
                String characteristicID = MainMenu.readUserMessage("Enter id");
                if (characteristicID.isEmpty())
                {
                    System.out.println(characteristicList);
                    continue;
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
