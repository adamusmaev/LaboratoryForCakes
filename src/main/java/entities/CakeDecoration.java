package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class CakeDecoration {

    @Setter
    @Getter
    private UUID cakeId;

    @Getter
    @Setter
    private UUID decorationId;
}
