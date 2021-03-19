package repositoryImpl;

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
            if (base.getUuid() == uuid)
            {
                return base;
            }

        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }

    public void addBase(Base base)
    {
        baseList.add(base);
    }
    public void deleteBase(Base base)
    {
        for (int i = 0; i < baseList.size(); i++)
        {
            if (base.equals(baseList.get(i)))
            {
                baseList.remove(i);
                break;
            }
        }
    }
    public void updateBase(Base base)
    {
        for (int i = 0; i < baseList.size(); i++)
        {
            if (base.equals(baseList.get(i)))
            {
                baseList.set(i, base);
                break;
            }
        }
    }
}
