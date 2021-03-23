package interfaces;

import entities.Base;
import entities.Characteristic;
import entities.Customer;
import entities.Decoration;
import lombok.Getter;
import lombok.Setter;

public interface Order {

    void addDecoration(Decoration decoration);
    void addCharacteristic(Characteristic characteristic);
}
