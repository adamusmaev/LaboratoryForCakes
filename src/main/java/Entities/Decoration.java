package Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@EqualsAndHashCode
@ToString
public class Decoration {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Float price;

    public Decoration(String name, Float price)
    {
        this.name = name;
        this.price = price;
    }

}
