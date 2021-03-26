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
    Base getBase();
    void setBase(Base base);
    Customer getCustomer();
    void setCustomer(Customer customer);
    String getName();
    void setName(String name);
    Float getPrice();
    void setPrice(Float price);

}
