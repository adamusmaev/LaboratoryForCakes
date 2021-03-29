package menu;

import entities.Base;
import facade.BaseFacade;
import repositoryimpl.BaseRepositoryImpl;

import java.util.Scanner;
import java.util.UUID;

import static entities.Container.baseList;

public class BaseMenu implements Menu{



    static public void showBaseMenu()
    {
        BaseRepositoryImpl baseRepository = new BaseRepositoryImpl();
        while (true)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Add new Base: 1");
            System.out.println("Remove base: 2");
            System.out.println("Update base: 3");
            System.out.println("Find base by name: 4");
            System.out.println("Show main menu: 5");
            int number = in.nextInt();
            if (number == 1){
                Scanner inBaseName = new Scanner(System.in);
                System.out.println("Enter the base name:");
                String baseName = inBaseName.nextLine();
                if (baseName.isEmpty())
                {
                    System.out.println("Enter correctly base name\n");
                    continue;
                }
                Base base = new Base(baseName);
                BaseFacade baseFacade = new BaseFacade(base, baseRepository);
                baseFacade.addBase();
            }
            if (number == 2)
            {
                Scanner inBaseId = new Scanner(System.in);
                System.out.println("Enter id");
                String baseId = inBaseId.nextLine();
                BaseFacade baseFacade;
                try {
                    baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                    baseFacade.removeBase();
                }
                catch (IllegalArgumentException ex)
                {
                    System.out.println("ID not found"+"\n");
                }
            }
            if (number == 3)
            {
                Scanner inBaseId = new Scanner(System.in);
                System.out.println("Enter id");
                String baseId = inBaseId.nextLine();
                System.out.println("Enter a new base name ");
                Scanner inNameBase = new Scanner(System.in);
                String newName = inNameBase.nextLine();
                BaseFacade baseFacade;
                try {
                    baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                    baseFacade.setName(newName);
                    baseFacade.updateBase();
                }
                catch (IllegalArgumentException ex) {
                    System.out.println("ID not found");
                }
            }
            if (number == 4)
            {
                Scanner inBaseId = new Scanner(System.in);
                System.out.println("Enter id");
                String baseId =inBaseId.nextLine();
                if (baseId.isEmpty())
                {
                    System.out.println(baseList);
                }
                else
                {
                    BaseFacade baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                    System.out.println(baseFacade.getBase().toString());
                }
            }
            if (number == 5){
                exit();
            }
        }

    }

    static public void exit()
    {
        MainMenu.showMainMenu();
    }
}
