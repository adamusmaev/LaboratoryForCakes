package facade;

import entities.Decoration;
import lombok.Getter;
import repositoryimpl.DecorationRepositoryImpl;

import java.util.List;
import java.util.UUID;

import static entities.Container.baseFacadeList;
import static entities.Container.decorationFacadeList;

public class DecorationFacade {
    @Getter
    private Decoration decoration;
    private DecorationRepositoryImpl decorationRepository;

    public DecorationFacade(Decoration decoration, DecorationRepositoryImpl decorationRepository)
    {
        this.decoration = decoration;
        this.decorationRepository = decorationRepository;
        decorationFacadeList.add(this);
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

    static public DecorationFacade getDecorationFacade(UUID decorationId)
    {
        for(DecorationFacade df : decorationFacadeList)
        {
            if (df.decoration.getUuid().equals(decorationId))
                return df;
        }
        throw new IllegalArgumentException();
    }
    public static Float getPriceOfTheAllDecorations(List<Decoration> decorationList) {
        if (decorationList.isEmpty()) return 0.0F;
        Float tmp = 0.0F;
        for (Decoration d : decorationList)
        {
            tmp = tmp+d.getPrice();
        }
        return tmp;
    }
}
