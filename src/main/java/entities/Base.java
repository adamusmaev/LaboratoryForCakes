package entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Base extends Entity{

    @Setter
    @Getter
    private String name;

    public Base(String name)
    {
        this.name = name;
    }
    public Base(Base base)
    {
        this.name = base.getName();
    }

}
