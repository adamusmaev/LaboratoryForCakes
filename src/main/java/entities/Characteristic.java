package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.log4j.Logger;


@EqualsAndHashCode
@ToString
public class Characteristic extends Entity {

    private final static Logger logger = Logger.getLogger(Characteristic.class);

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
        logger.info("Create characteristic with name: " + name +
                " subscription" + subscription);
    }
}
