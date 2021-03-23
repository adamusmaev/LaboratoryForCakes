package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static entities.Container.decorationCharacteristicList;

@ToString
public class DecorationCharacteristic {

    @Getter
    @Setter
    private Decoration decoration;

    @Getter
    @Setter
    private  Characteristic characteristic;

    public DecorationCharacteristic(Decoration decoration, Characteristic characteristic) {
        this.decoration = decoration;
        this.characteristic = characteristic;
    }

    public static void addDecorationCharacteristic(Decoration decoration, Characteristic characteristic)
    {
        decorationCharacteristicList.add(new DecorationCharacteristic(decoration, characteristic));
    }


}
