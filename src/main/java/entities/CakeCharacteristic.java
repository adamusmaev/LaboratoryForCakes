package entities;


import interfaces.Storable;
import lombok.Getter;
import lombok.Setter;

public class CakeCharacteristic implements Storable {

    @Setter
    @Getter
    private Cake cake;

    @Getter
    @Setter
    private  Characteristic characteristic;
}
