package menu;

import repositoryimpl.BaseRepositoryImpl;

import java.util.Scanner;

public class MainMenu {

    static public void showMainMenu() {
        while (true) {
            System.out.println("Editing cake bases: 1");
            System.out.println("Editing cake decorations: 2");
            System.out.println("Editing characteristics for a cake: 3");
            System.out.println("Issuing a cake for a customer: 4");
            System.out.println("Exit: 5");

            int number = Integer.parseInt(MainMenu.readUserMessage());
            if (number == 1) BaseMenu.showBaseMenu();
            if (number == 2) DecorationMenu.showDecorationMenu();
            if (number == 3) CharacteristicMenu.showCharacteristicMenu();
            if (number == 4) CakeMenu.showCakeMenu();
            if (number == 5) exit();
        }

    }

    public static void exit() {
        System.exit(1);
    }

    public static void printMenu(String menuName) {
        System.out.println("Add new " + menuName + ": 1");
        System.out.println("Remove " + menuName + ": 2");
        System.out.println("Update " + menuName + ": 3");
        System.out.println("Find " + menuName + "by ID: 4");
        System.out.println("Show main menu: 5");
    }

    public static String readUserMessage(String messageToUser){
        Scanner inBaseName = new Scanner(System.in);
        System.out.println(messageToUser);
        String baseName = inBaseName.nextLine();
        return baseName;
    }
    public static String readUserMessage(){
        Scanner inBaseName = new Scanner(System.in);
        String baseName = inBaseName.nextLine();
        return baseName;
    }
}
