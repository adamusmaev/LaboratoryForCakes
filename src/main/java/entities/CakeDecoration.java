package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class CakeDecoration {

    @Setter
    @Getter
    private Cake cake;

    @Getter
    @Setter
    private Decoration decoration;

    public CakeDecoration(Cake cake, Decoration decoration) {
        this.cake = cake;
        this.decoration = decoration;
    }


}
