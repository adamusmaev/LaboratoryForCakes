package repositoryimpl;

import entities.Base;
import lombok.ToString;
import org.apache.log4j.Logger;

import java.util.UUID;
import static entities.Container.baseList;


@ToString
public class BaseRepositoryImpl {

    private final static Logger logger = Logger.getLogger(BaseRepositoryImpl.class);
    public Object getBaseById(UUID uuid)
    {
        for (Base base: baseList) {
            if (base.getUuid().equals(uuid))
            {
                return base;
            }

        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }

    public void addBase(Base base)
    {
        baseList.add(new Base(base));
    }
    public void deleteBase(Base base)
    {
        for (Base b : baseList)
        {
            if (base.getUuid().equals(b.getUuid()))
            {
                baseList.remove(b);
                break;
            }
        }
        logger.info("Delete " + base.toString());
    }
    public void updateBase(Base base)
    {
        for (Base b : baseList)
        {
            if (base.getUuid().equals(b.getUuid()))
            {
                baseList.remove(b);
                baseList.add(base);
                break;
            }
        }
        logger.info("Update base in baseList");
    }
}
