package menu;

import entities.Base;
import entities.Decoration;
import facade.BaseFacade;
import facade.DecorationFacade;
import repositoryimpl.DecorationRepositoryImpl;

import java.util.Scanner;
import java.util.UUID;

import static entities.Container.decorationList;

public class DecorationMenu {

    public static void showDecorationMenu()
    {
        DecorationRepositoryImpl decorationRepository = new DecorationRepositoryImpl();
        while (true)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Add new decoration: 1");
            System.out.println("Remove decoration: 2");
            System.out.println("Update decoration: 3");
            System.out.println("Find decoration by name: 4");
            System.out.println("Show main menu: 5");
            int number = in.nextInt();
            if (number == 1)
            {
                Scanner inDecorationName = new Scanner(System.in);
                System.out.println("Enter the decoration name:");
                String decorationName = inDecorationName.nextLine();
                Scanner inDecorationPrice = new Scanner(System.in);
                System.out.println("Enter the decoration price:");
                Float decorationPrice = inDecorationPrice.nextFloat();
                Decoration decoration = new Decoration(decorationName, decorationPrice);
                DecorationFacade decorationFacade = new DecorationFacade(decoration, decorationRepository);
                decorationFacade.addDecoration();
            }
            if (number == 2)
            {
                Scanner inDecorationId = new Scanner(System.in);
                System.out.println("Enter the decoration ID:");
                String decorationId = inDecorationId.nextLine();
                DecorationFacade decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                decorationFacade.removeDecoration();
            }
            if (number == 3)
            {
                Scanner inDecorationId = new Scanner(System.in);
                System.out.println("Enter the decoration ID:");
                String decorationId = inDecorationId.nextLine();
                Scanner inNewDecorationName = new Scanner(System.in);
                System.out.println("Enter the new decoration name:");
                String newDecorationName = inDecorationId.nextLine();
                Scanner inNewDecorationPrice = new Scanner(System.in);
                System.out.println("Enter the new decoration price:");
                Float newDecorationPrice = inDecorationId.nextFloat();
                DecorationFacade decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                decorationFacade.setDecorationName(newDecorationName);
                decorationFacade.setDecorationPrise(newDecorationPrice);
                decorationFacade.updateDecoration();
            }
            if (number == 4)
            {
                Scanner inDecorationId = new Scanner(System.in);
                System.out.println("Enter the decoration ID:");
                String decorationId = inDecorationId.nextLine();
                if (decorationId.isEmpty())
                {
                    System.out.println(decorationList);
                }
                else
                {
                    DecorationFacade decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                    System.out.println(decorationFacade.getDecoration().toString());
                }

            }
            if (number == 5) exit();
        }
    }
    static void exit()
    {
        MainMenu.showMainMenu();
    }
}
