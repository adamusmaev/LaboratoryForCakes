package entities;

import interfaces.Storable;
import lombok.Getter;
import lombok.Setter;

public class CakeDecoration implements Storable {

    @Setter
    @Getter
    private Cake cake;

    @Getter
    @Setter
    private Decoration decoration;
}
