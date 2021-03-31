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
            System.out.println("Add new decoration: 1");
            System.out.println("Remove decoration: 2");
            System.out.println("Update decoration: 3");
            System.out.println("Find decoration by ID: 4");
            System.out.println("Show main menu: 5");
            int number = in.nextInt();
            if (number == 1) {
                Scanner inDecorationName = new Scanner(System.in);
                System.out.println("Enter the decoration name:");
                String decorationName = inDecorationName.nextLine();
                while (true) {
                    if (decorationName.isEmpty()) {
                        System.out.println("Enter correctly decoration name\n");
                        inDecorationName = new Scanner(System.in);
                        decorationName = inDecorationName.nextLine();
                        continue;
                    }
                    break;
                }
                Scanner inDecorationPrice = new Scanner(System.in);
                System.out.println("Enter the decoration price:");
                String decorationPriceStr = inDecorationPrice.nextLine();
                Float decorationPrice = null;
                while (true) {
                    if (decorationPriceStr.isEmpty()) {
                        System.out.println("Enter correctly decoration price\n");
                        inDecorationPrice = new Scanner(System.in);
                        decorationPriceStr = inDecorationPrice.nextLine();
                        continue;
                    }
                    try {
                        decorationPrice = Float.parseFloat(decorationPriceStr);
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Enter correctly decoration price\n");
                        inDecorationPrice = new Scanner(System.in);
                        decorationPriceStr = inDecorationPrice.nextLine();
                        continue;
                    }
                }
                Decoration decoration = new Decoration(decorationName, decorationPrice);
                DecorationFacade decorationFacade = new DecorationFacade(decoration, decorationRepository);
                decorationFacade.addDecoration();
            }
            if (number == 2) {
                Scanner inDecorationId = new Scanner(System.in);
                System.out.println("Enter the decoration ID:");
                String decorationId = inDecorationId.nextLine();
                try {
                    DecorationFacade decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                    decorationFacade.removeDecoration();
                } catch (IllegalArgumentException ex) {
                    System.out.println("ID not found" + "\n");
                }

            }
            if (number == 3) {
                Scanner inDecorationId = new Scanner(System.in);
                System.out.println("Enter the decoration ID:");
                String decorationId = inDecorationId.nextLine();
                DecorationFacade decorationFacade;
                try {
                    decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                }
                catch (IllegalArgumentException ex)
                {
                    System.out.println("ID not found");
                    continue;
                }
                Scanner inNewDecorationName = new Scanner(System.in);
                System.out.println("Enter the new decoration name:");
                String newDecorationName = inNewDecorationName.nextLine();
                while (true) {
                    if (newDecorationName.isEmpty()) {
                        System.out.println("Enter correctly decoration name\n");
                        inNewDecorationName = new Scanner(System.in);
                        newDecorationName = inNewDecorationName.nextLine();
                        continue;
                    }
                    break;
                }
                Scanner inNewDecorationPrice = new Scanner(System.in);
                System.out.println("Enter the new decoration price:");
                String decorationPriceStr = inNewDecorationPrice.nextLine();
                Float decorationPrice = null;
                while (true) {
                    if (decorationPriceStr.isEmpty()) {
                        System.out.println("Enter correctly decoration price\n");
                        inNewDecorationPrice = new Scanner(System.in);
                        decorationPriceStr = inNewDecorationPrice.nextLine();
                        continue;
                    }
                    try {
                        decorationPrice = Float.parseFloat(decorationPriceStr);
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Enter correctly decoration price\n");
                        inNewDecorationPrice = new Scanner(System.in);
                        decorationPriceStr = inNewDecorationPrice.nextLine();
                        continue;
                    }
                }
                decorationFacade.setDecorationName(newDecorationName);
                decorationFacade.setDecorationPrise(decorationPrice);
                decorationFacade.updateDecoration();
            }
            if (number == 4) {
                Scanner inDecorationId = new Scanner(System.in);
                System.out.println("Enter the decoration ID:");
                String decorationId = inDecorationId.nextLine();
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
