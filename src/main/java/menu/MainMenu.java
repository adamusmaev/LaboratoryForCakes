package menu;

import repositoryimpl.BaseRepositoryImpl;

import java.util.Scanner;

public class MainMenu{

    static public void showMainMenu()
    {
        while (true)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Editing cake bases: 1");
            System.out.println("Editing cake decorations: 2");
            System.out.println("Editing characteristics for a cake: 3");
            System.out.println("Issuing a cake for a customer: 4");
            System.out.println("Exit: 5");

            int number = in.nextInt();
            if (number == 1) BaseMenu.showBaseMenu();
            if (number == 2) DecorationMenu.showDecorationMenu();
            if (number == 3) CharacteristicMenu.showCharacteristicMenu();
            if (number == 4) CakeMenu.showCakeMenu();
            if (number == 5) exit();
        }

    }

    static public void exit()
    {
        System.exit(1);
    }

}
