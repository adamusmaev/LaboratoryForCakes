package facade;

import entities.Base;
import lombok.Getter;
import repositoryimpl.BaseRepositoryImpl;

import java.util.UUID;

import static entities.Container.baseFacadeList;

public class BaseFacade {

    private BaseRepositoryImpl baseRepository;
    @Getter
    private Base base;

    public BaseFacade(Base base, BaseRepositoryImpl baseRepository)
    {
        this.baseRepository = baseRepository;
        this.base = base;
    }

    public void addBase()
    {
        baseRepository.addBase(base);
        baseFacadeList.add(this);
    }
    public Object getBaseById(UUID uuid)
    {
        return baseRepository.getBaseById(uuid);
    }
    public void removeBase()
    {
        baseRepository.deleteBase(base);
    }
    public void updateBase()
    {
        baseRepository.updateBase(base);
    }
    public void setName(String name)
    {
        base.setName(name);
    }
    public String getName()
    {
        return base.getName();
    }

    static public BaseFacade getBaseFacade(UUID baseId)
    {
        for(BaseFacade bf : baseFacadeList)
        {
            if (bf.base.getUuid().equals(baseId))
            {
                return bf;
            }
        }
        throw new IllegalArgumentException();
    }
}
