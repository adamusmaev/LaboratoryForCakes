package repositoryImpl;

import entities.Cake;
import org.apache.log4j.Logger;

import java.util.UUID;

import static entities.Container.cakeList;

public class CakeRepositoryImpl {
    private final static Logger logger = Logger.getLogger(BaseRepositoryImpl.class);

    public Object getCakeById(UUID uuid)
    {
        for (int i = 0; i < cakeList.size(); i++)
        {
            if (uuid == cakeList.get(i).getUuid())
            {
                return cakeList.get(i);
            }
        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }
    public void addCake(Cake cake)
    {
        cakeList.add(cake);
    }
    public void removeCake(Cake cake)
    {
        for (int i = 0; i < cakeList.size(); i++)
        {
            if (cake.equals(cakeList.get(i)))
            {
                cakeList.remove(i);
                break;
            }
        }
    }
    public void updateCake(Cake cake)
    {
        for (int i = 0; i < cakeList.size(); i++)
        {
            if (cake.equals(cakeList.get(i)))
            {
                cakeList.set(i, cake);
                break;
            }
        }
    }
}
