package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;


@EqualsAndHashCode
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

    public Characteristic(Characteristic characteristic)
    {
        this.name = characteristic.name;
        this.subscription = characteristic.subscription;
        this.setUuid(characteristic.getUuid());
        logger.info("Create characteristic with name: " + name +
                " subscription" + subscription);
    }

    public String toString() {
        return "Characteristic(ID=" + this.getUuid() +"name=" + this.name + ", subscription=" + this.subscription + ")";
    }
}
