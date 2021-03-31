package menu;

import entities.Cake;
import entities.Customer;
import entities.Decoration;
import facade.BaseFacade;
import facade.CakeFacade;
import facade.DecorationFacade;
import repositoryimpl.CakeRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static entities.Container.cakeList;

public class CakeMenu {

    public static void showCakeMenu() {
        BaseFacade baseFacade;
        CakeRepositoryImpl cakeRepository = new CakeRepositoryImpl();
        List<Decoration> decorationList = new ArrayList<>();

        Scanner inFirstName = new Scanner(System.in);
        System.out.println("Enter your firstname:");
        String firstName = inFirstName.nextLine();
        while (true) {
            if (firstName.isEmpty()) {
                System.out.println("Enter correctly firstname\n");
                inFirstName = new Scanner(System.in);
                firstName = inFirstName.nextLine();
                continue;
            }
            break;
        }
        Scanner inLastName = new Scanner(System.in);
        System.out.println("Enter your lastname:");
        String lastName = inLastName.nextLine();
        while (true) {
            if (lastName.isEmpty()) {
                System.out.println("Enter correctly lastname\n");
                inLastName = new Scanner(System.in);
                lastName = inLastName.nextLine();
                continue;
            }
            break;
        }
        Scanner inCakeName = new Scanner(System.in);
        System.out.println("Enter cake name:");
        String cakeName = inCakeName.nextLine();
        while (true) {
            if (cakeName.isEmpty()) {
                System.out.println("Enter correctly cake name\n");
                inCakeName = new Scanner(System.in);
                cakeName = inCakeName.nextLine();
                continue;
            }
            break;
        }
        Scanner inCakePrice = new Scanner(System.in);
        System.out.println("Enter cake price:");
        String cakePriceStr = inCakePrice.nextLine();
        Float cakePrice = null;
        while (true) {
            if (cakePriceStr.isEmpty()) {
                System.out.println("Enter correctly cake price\n");
                inCakePrice = new Scanner(System.in);
                cakePriceStr = inCakePrice.nextLine();
                continue;
            }
            try {
                cakePrice = Float.parseFloat(cakePriceStr);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Enter correctly cake price\n");
                inCakePrice = new Scanner(System.in);
                cakePriceStr = inCakePrice.nextLine();
                continue;
            }
        }
        System.out.println("Enter base id");
        Scanner inBaseId = new Scanner(System.in);
        String baseId = inBaseId.nextLine();
        while (true) {
            try {
                baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println("Id not found. Enter correctly base Id");
                inBaseId = new Scanner(System.in);
                baseId = inBaseId.nextLine();
                continue;
            }
        }
        while (true) {
            Scanner inDecorationId = new Scanner(System.in);
            System.out.println("Enter the decoration ID:");
            String decorationId = inDecorationId.nextLine();
            if (decorationId.isEmpty()) break;
            else {
                try {
                    DecorationFacade decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                    decorationList.add(decorationFacade.getDecoration());
                } catch (IllegalArgumentException ex) {
                    System.out.println("Id not found");
                    continue;
                }
            }
        }
        cakePrice = cakePrice + DecorationFacade.getPriceOfTheAllDecorations(decorationList);
        Customer customer = new Customer(lastName, firstName);
        Cake cake = new Cake(cakeName, cakePrice, customer, baseFacade.getBase());
        CakeFacade cakeFacade = new CakeFacade(cake, cakeRepository);
        cakeFacade.addDecoration(decorationList);
        cakeFacade.addCake();
        System.out.println(cakeList.toString());
    }

    public static void exit() {
        MainMenu.showMainMenu();
    }
}
