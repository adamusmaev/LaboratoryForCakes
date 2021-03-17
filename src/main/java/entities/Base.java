package entities;


import intarfaces.Storable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Base implements Storable {


    @Setter
    @Getter
    private String name;

    public Base(String name)
    {
        this.name = name;
    }

}
