package entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CakeCharacteristic {

    @Setter
    @Getter
    private Cake cake;

    @Getter
    @Setter
    private  Characteristic characteristic;

    public CakeCharacteristic(Cake cake, Characteristic characteristic) {
        this.cake = cake;
        this.characteristic = characteristic;
    }
}
