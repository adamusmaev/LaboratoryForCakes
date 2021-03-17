package entities;

import interfaces.Storable;
import lombok.Getter;
import lombok.Setter;

public class DecorationCharacteristic  implements Storable {

    @Getter
    @Setter
    private Decoration decoration;

    @Getter
    @Setter
    private  Characteristic characteristic;
}
