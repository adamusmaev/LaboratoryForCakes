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


        String firstName = MainMenu.readUserMessage("Enter your firstname:");
        while (true) {
            if (firstName.isEmpty()) {
                firstName = MainMenu.readUserMessage("Enter correctly firstname\n");
                continue;
            }
            break;
        }
        String lastName = MainMenu.readUserMessage("Enter your lastname:");
        while (true) {
            if (lastName.isEmpty()) {
                lastName = MainMenu.readUserMessage("Enter correctly lastname\n");
                continue;
            }
            break;
        }
        String cakeName = MainMenu.readUserMessage("Enter cake name:");
        while (true) {
            if (cakeName.isEmpty()) {
                cakeName = MainMenu.readUserMessage("Enter correctly cake name\n");
                continue;
            }
            break;
        }
        String cakePriceStr = MainMenu.readUserMessage("Enter cake price:");
        Float cakePrice = null;
        while (true) {
            if (cakePriceStr.isEmpty()) {
                cakePriceStr = MainMenu.readUserMessage("Enter correctly cake price\n");
                continue;
            }
            try {
                cakePrice = Float.parseFloat(cakePriceStr);
                break;
            } catch (NumberFormatException ex) {
                cakePriceStr = MainMenu.readUserMessage("Enter correctly cake price\n");
                continue;
            }
        }
        String baseId = MainMenu.readUserMessage("Enter base id");
        while (true) {
            try {
                baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
                break;
            } catch (IllegalArgumentException ex) {
                baseId = MainMenu.readUserMessage("Id not found. Enter correctly base Id");
                continue;
            }
        }
        while (true) {
            String decorationId = MainMenu.readUserMessage("Enter the decoration ID:");
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
