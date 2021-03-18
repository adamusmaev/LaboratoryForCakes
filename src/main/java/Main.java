import entities.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("customerName", "customerFirstName");
        Customer customer1 = new Customer("customerName", "customerFirstName");
        System.out.println(customer.getUuid());
        System.out.println(customer1.getUuid());
        Characteristic characteristic = new Characteristic("test1", "test2");
        Base base = new Base("testBase");
        Cake cake = new Cake("test", 100.0F, customer, base);
        System.out.println(cake.toString());

    }
}
