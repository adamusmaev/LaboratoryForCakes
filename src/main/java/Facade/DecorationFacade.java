package Facade;

import entities.Decoration;
import repositoryimpl.DecorationRepositoryImpl;

import java.util.UUID;

public class DecorationFacade {
    private Decoration decoration;
    private DecorationRepositoryImpl decorationRepository;

    public DecorationFacade(Decoration decoration, DecorationRepositoryImpl decorationRepository)
    {
        this.decoration = decoration;
        this.decorationRepository = decorationRepository;
    }
    public Object getDecorationById(UUID uuid)
    {
        return decorationRepository.getDecorationById(uuid);
    }
    public void addDecoration()
    {
        decorationRepository.addDecoration(decoration);
    }
    public void removeDecoration()
    {
        decorationRepository.removeDecoration(decoration);
    }
    public void updateDecoration()
    {
        decorationRepository.updateDecoration(decoration);
    }
    public String getDecorationName()
    {
        return decoration.getName();
    }
    public void setDecorationName(String name)
    {
        decoration.setName(name);
    }
    public Float getDecorationPrice()
    {
        return decoration.getPrice();
    }
    public void setDecorationPrise(Float prise)
    {
        decoration.setPrice(prise);
    }
}
