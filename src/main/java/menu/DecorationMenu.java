package menu;

import entities.Base;
import entities.Decoration;
import facade.BaseFacade;
import facade.DecorationFacade;
import repositoryimpl.DecorationRepositoryImpl;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

import static entities.Container.decorationList;

public class DecorationMenu {

    public static void showDecorationMenu() {
        DecorationRepositoryImpl decorationRepository = new DecorationRepositoryImpl();
        while (true) {
            Scanner in = new Scanner(System.in);
            MainMenu.printMenu("Decoration");
            int number = in.nextInt();
            if (number == 1) {
                String decorationName = MainMenu.readUserMessage("Enter the decoration name:");
                while (true) {
                    if (decorationName.isEmpty()) {
                        decorationName = MainMenu.readUserMessage("Enter correctly decoration name\n");
                        continue;
                    }
                    break;
                }
                String decorationPriceStr = MainMenu.readUserMessage("Enter the decoration price:");
                Float decorationPrice = null;
                while (true) {
                    if (decorationPriceStr.isEmpty()) {
                        decorationPriceStr = MainMenu.readUserMessage("Enter correctly decoration price\n");
                        continue;
                    }
                    try {
                        decorationPrice = Float.parseFloat(decorationPriceStr);
                        break;
                    } catch (NumberFormatException ex) {
                        decorationPriceStr = MainMenu.readUserMessage("Enter correctly decoration price\n");
                        continue;
                    }
                }
                Decoration decoration = new Decoration(decorationName, decorationPrice);
                DecorationFacade decorationFacade = new DecorationFacade(decoration, decorationRepository);
                decorationFacade.addDecoration();
            }
            if (number == 2) {
                String decorationId = MainMenu.readUserMessage("Enter the decoration ID:");
                try {
                    DecorationFacade decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                    decorationFacade.removeDecoration();
                } catch (IllegalArgumentException ex) {
                    System.out.println("ID not found" + "\n");
                }

            }
            if (number == 3) {
                String decorationId = MainMenu.readUserMessage("Enter the decoration ID:");
                DecorationFacade decorationFacade;
                try {
                    decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                } catch (IllegalArgumentException ex) {
                    System.out.println("ID not found");
                    continue;
                }
                String newDecorationName = MainMenu.readUserMessage("Enter the new decoration name:");
                while (true) {
                    if (newDecorationName.isEmpty()) {
                        newDecorationName = MainMenu.readUserMessage("Enter correctly decoration name\n");
                        continue;
                    }
                    break;
                }
                String decorationPriceStr = MainMenu.readUserMessage("Enter the new decoration price:");
                Float decorationPrice = null;
                while (true) {
                    if (decorationPriceStr.isEmpty()) {
                        decorationPriceStr = MainMenu.readUserMessage("Enter correctly decoration price\n");
                        continue;
                    }
                    try {
                        decorationPrice = Float.parseFloat(decorationPriceStr);
                        break;
                    } catch (NumberFormatException ex) {
                        decorationPriceStr = MainMenu.readUserMessage("Enter correctly decoration price\n");
                        continue;
                    }
                }
                decorationFacade.setDecorationName(newDecorationName);
                decorationFacade.setDecorationPrise(decorationPrice);
                decorationFacade.updateDecoration();
            }
            if (number == 4) {
                String decorationId = MainMenu.readUserMessage("Enter the decoration ID:");
                if (decorationId.isEmpty()) {
                    System.out.println(decorationList);
                    continue;
                }
                try {
                    DecorationFacade decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                    System.out.println(decorationFacade.getDecoration().toString());
                } catch (IllegalArgumentException ex) {
                    System.out.println("ID not found" + "\n");
                }
            }
            if (number == 5) exit();
        }
    }

    static void exit() {
        MainMenu.showMainMenu();
    }
}
