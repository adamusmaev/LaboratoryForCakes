package Entities;


import lombok.Getter;
import lombok.Setter;

public class CakeCharacteristic {

    @Setter
    @Getter
    private Cake cake;

    @Getter
    @Setter
    private  Characteristic characteristic;
}
