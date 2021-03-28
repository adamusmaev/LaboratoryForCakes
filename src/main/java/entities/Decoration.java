package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;


@EqualsAndHashCode
public class Decoration extends Entity {

    private final static Logger logger = Logger.getLogger(Decoration.class);

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
        logger.info("Create decoration with name: " + name +
                " price: " + price);
    }
    public Decoration(Decoration decoration)
    {
        this.name = decoration.name;
        this.price = decoration.getPrice();
        this.setUuid(decoration.getUuid());
    }

    public String toString() {
        return "Decoration(ID=" +this.getUuid()+  ", name=" + this.name + ", price=" + this.price + ")";
    }
}
