package Facade;

import entities.Base;
import repositoryimpl.BaseRepositoryImpl;

import java.util.UUID;

public class BaseFacade {

    private BaseRepositoryImpl baseRepository;
    private Base base;

    public BaseFacade(Base base, BaseRepositoryImpl baseRepository)
    {
        this.baseRepository = baseRepository;
        this.base = base;
    }

    public void addBase()
    {
        baseRepository.addBase(base);
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
}
