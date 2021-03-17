import entities.*;

public class Main {
    public static void main(String[] args) {

        Base base = new Base("test");
        Container container = new Container();
        container.setEntity(base);
        System.out.println(container.getListEntities().toString());
    }
}
