package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class DecorationCharacteristic {

    @Getter
    @Setter
    private UUID decorationId;

    @Getter
    @Setter
    private  UUID characteristicId;
}
