package entities;

import lombok.Getter;
import lombok.Setter;

public class CakeDecoration {

    @Setter
    @Getter
    private Cake cake;

    @Getter
    @Setter
    private Decoration decoration;
}
