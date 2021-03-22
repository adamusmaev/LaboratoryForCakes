package interfaces;

import entities.Characteristic;
import entities.Decoration;

public interface Order {

    void addDecoration(Decoration decoration);
    void addCharacteristic(Characteristic characteristic);

}
