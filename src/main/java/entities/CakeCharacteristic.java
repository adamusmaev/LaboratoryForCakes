package entities;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class CakeCharacteristic {

    @Setter
    @Getter
    private UUID cakeId;

    @Getter
    @Setter
    private  UUID characteristicId;
}
