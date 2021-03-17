package Entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Base {

    @Setter
    @Getter
    private String name;

    public Base(String name)
    {
        this.name = name;
    }
}
