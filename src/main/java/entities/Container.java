package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Container {

    public final static Set<Cake> cakeList = new HashSet<>();
    public final static Set<Base> baseList = new HashSet<>();
    public final static Set<Customer> customerList = new HashSet<>();
    public final static Set<Decoration> decorationList = new HashSet<>();
    public final static List<CakeCharacteristic> cakeCharacteristicList = new ArrayList<>();
    public final static List<CakeDecoration> cakeDecorationList = new ArrayList<>();
    public final static List<DecorationCharacteristic> decorationCharacteristicList = new ArrayList<>();
    public final static Set<Characteristic> characteristicList = new HashSet<>();
}
