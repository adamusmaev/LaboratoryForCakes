package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.log4j.Logger;


@EqualsAndHashCode
@ToString
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

}
