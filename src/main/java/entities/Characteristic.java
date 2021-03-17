package entities;

import intarfaces.Storable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Characteristic implements Storable {

    @Setter
    @Getter
    private String name;

    @Getter
    @Setter
    private String subscription;

    public Characteristic(String name, String subscription)
    {
        this.name = name;
        this.subscription = subscription;
    }
}
