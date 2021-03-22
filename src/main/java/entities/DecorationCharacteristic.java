package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DecorationCharacteristic {

    @Getter
    @Setter
    private Decoration decoration;

    @Getter
    @Setter
    private  Characteristic characteristic;


}
