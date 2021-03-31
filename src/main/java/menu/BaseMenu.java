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
            System.out.println("Add new Base: 1");
            System.out.println("Remove base: 2");
            System.out.println("Update base: 3");
            System.out.println("Find base by ID: 4");
            System.out.println("Show main menu: 5");
            int number = in.nextInt();
            if (number == 1) {
                Scanner inBaseName = new Scanner(System.in);
                System.out.println("Enter the base name:");
                String baseName = inBaseName.nextLine();
                while (true) {
                    if (baseName.isEmpty()) {
                        System.out.println("Enter correctly base name\n");
                        inBaseName = new Scanner(System.in);
                        baseName = inBaseName.nextLine();
                        continue;
                    }
                    break;
                }
                Base base = new Base(baseName);
                BaseFacade baseFacade = new BaseFacade(base, baseRepository);
                baseFacade.addBase();
            }
            if (number == 2) {
                Scanner inBaseId = new Scanner(System.in);
                System.out.println("Enter id");
                String baseId = inBaseId.nextLine();
                BaseFacade baseFacade;
                try {
                    baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                    baseFacade.removeBase();
                } catch (IllegalArgumentException ex) {
                    System.out.println("ID not found" + "\n");
                }
            }
            if (number == 3) {
                Scanner inBaseId = new Scanner(System.in);
                System.out.println("Enter id");
                String baseId = inBaseId.nextLine();
                BaseFacade baseFacade = null;
                try {
                    baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                } catch (IllegalArgumentException ex) {
                    System.out.println("ID not found");
                    continue;
                }
                System.out.println("Enter a new base name ");
                Scanner inNameBase = new Scanner(System.in);
                String newName = inNameBase.nextLine();
                while (true) {
                    if (newName.isEmpty()) {
                        System.out.println("Enter correctly new base name\n");
                        inNameBase = new Scanner(System.in);
                        newName = inNameBase.nextLine();
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
                Scanner inBaseId = new Scanner(System.in);
                System.out.println("Enter id");
                String baseId = inBaseId.nextLine();
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
