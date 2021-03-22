package entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.log4j.Logger;


@EqualsAndHashCode
@ToString
public class Base extends Entity{

    private static final Logger logger = Logger.getLogger(Base.class);

    @Setter
    @Getter
    private String name;

    public Base(String name)
    {
        this.name = name;
        logger.info("Create base with name: " + name);
    }
    public Base(Base base)
    {
        this.name = base.name;
        this.setUuid(base.getUuid());
        logger.info("Create base with name: " + name);
    }

}
