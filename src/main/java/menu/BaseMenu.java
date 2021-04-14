package menu;

import entities.Base;
import facade.BaseFacade;
import repositoryimpl.BaseRepositoryImpl;

import java.util.Scanner;
import java.util.UUID;

import static entities.Container.baseList;

public class BaseMenu {


    static public void showBaseMenu() {
        BaseRepositoryImpl baseRepository = new BaseRepositoryImpl();
        while (true) {
            Scanner in = new Scanner(System.in);
            MainMenu.printMenu("Base");
            int number = in.nextInt();
            if (number == 1) {
                String baseName = MainMenu.readUserMessage("Enter the base name:");
                while (true) {
                    if (baseName.isEmpty()) {
                        baseName = MainMenu.readUserMessage("Enter correctly base name\n");
                        continue;
                    }
                    break;
                }
                Base base = new Base(baseName);
                BaseFacade baseFacade = new BaseFacade(base, baseRepository);
                baseFacade.addBase();
            }
            if (number == 2) {
                String baseId = MainMenu.readUserMessage("Enter id");
                BaseFacade baseFacade;
                try {
                    baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                    baseFacade.removeBase();
                } catch (IllegalArgumentException ex) {
                    System.out.println("ID not found" + "\n");
                }
            }
            if (number == 3) {
                String baseId = MainMenu.readUserMessage("Enter id");
                BaseFacade baseFacade = null;
                try {
                    baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                } catch (IllegalArgumentException ex) {
                    System.out.println("ID not found");
                    continue;
                }
                String newName = MainMenu.readUserMessage("Enter a new base name ");
                while (true) {
                    if (newName.isEmpty()) {
                        newName = MainMenu.readUserMessage("Enter correctly new base name\n");
                        continue;
                    }
                    break;
                }
                if (baseFacade != null) {
                    baseFacade.setName(newName);
                    baseFacade.updateBase();
                }
            }
            if (number == 4) {
                String baseId = MainMenu.readUserMessage("Enter id");
                if (baseId.isEmpty()) {
                    System.out.println(baseList);
                    continue;
                }
                try {
                    BaseFacade baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                    System.out.println(baseFacade.getBase().toString());
                } catch (IllegalArgumentException ex) {
                    System.out.println("ID not found" + "\n");
                    System.out.println(baseList);
                }
            }
            if (number == 5) {
                exit();
            }
        }
    }

    static public void exit() {
        MainMenu.showMainMenu();
    }
}
