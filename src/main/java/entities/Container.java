package entities;

import java.util.ArrayList;
import java.util.List;
import interfaces.Storable;

public class Container {

    private List<Storable> list = new ArrayList<>();

    public List<Storable> getListEntities()
    {
        return list;
    }

    public void setEntity(Storable storable) {
        list.add(storable);
    }
    /*private List<Cake> cakeList = new ArrayList<>();
    private List<Base> baseList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<Decoration> decorationList = new ArrayList<>();
    private List<CakeCharacteristic> cakeCharacteristicList = new ArrayList<>();
    private List<CakeDecoration> cakeDecorationList = new ArrayList<>();
    private List<DecorationCharacteristic> decorationCharacteristicList = new ArrayList<>();*/


}
