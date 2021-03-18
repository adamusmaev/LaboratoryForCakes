package repositoryImpl;

import entities.Base;
import java.util.UUID;
import static entities.Container.baseList;

public class BaseRepositoryImpl {

    public Object getBaseById(UUID uuid)
    {
        for (Base base: baseList) {
            if (base.getUuid() == uuid)
            {
                return base;
            }

        }
        return new IllegalArgumentException("This id: " + uuid + "not found");
    }

    public void addBase(Base base)
    {
        baseList.add(base);
    }
    public void deleteBase(Base base)
    {
        for (int i = 0; i < baseList.size(); i++)
        {
            if (base == baseList.get(i))
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
            if (base == baseList.get(i))
            {
                baseList.set(i, base);
                break;
            }
        }
    }
}
