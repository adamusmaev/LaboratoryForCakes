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

    public static void showCakeMenu()
    {
        BaseFacade baseFacade;
        CakeRepositoryImpl cakeRepository = new CakeRepositoryImpl();
        List<Decoration> decorationList = new ArrayList<>();

        Scanner inFirstName = new Scanner(System.in);
        System.out.println("Enter your firstname:");
        String firstName = inFirstName.nextLine();
        Scanner inLastName = new Scanner(System.in);
        System.out.println("Enter your lastname:");
        String lastName = inLastName.nextLine();
        Scanner inBaseId = new Scanner(System.in);
        Scanner inCakeName = new Scanner(System.in);
        System.out.println("Enter cake name:");
        String cakeName = inCakeName.nextLine();
        Scanner inCakePrice = new Scanner(System.in);
        System.out.println("Enter cake price:");
        Float cakePrice = inCakePrice.nextFloat();
        System.out.println("Enter base id");
        String baseId = inBaseId.nextLine();
        baseFacade = BaseFacade.getBaseFacade(UUID.fromString(baseId));
        while (true)
        {
            Scanner inDecorationId = new Scanner(System.in);
            System.out.println("Enter the decoration ID:");
            String decorationId = inDecorationId.nextLine();
            if (decorationId.isEmpty()) break;
            else
            {
                DecorationFacade decorationFacade = DecorationFacade.getDecorationFacade(UUID.fromString(decorationId));
                decorationList.add(decorationFacade.getDecoration());
            }
        }
        cakePrice = cakePrice + DecorationFacade.getPriceOfTheAllDecorations(decorationList);
        Customer customer = new Customer(lastName,firstName);
        Cake cake = new Cake(cakeName, cakePrice, customer, baseFacade.getBase());
        CakeFacade cakeFacade = new CakeFacade(cake, cakeRepository);
        cakeFacade.addDecoration(decorationList);
        cakeFacade.addCake();
        System.out.println(cakeList.toString());
    }

    public static void exit()
    {
        MainMenu.showMainMenu();
    }
}
