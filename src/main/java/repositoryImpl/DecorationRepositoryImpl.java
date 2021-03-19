package repositoryImpl;

import entities.Decoration;
import org.apache.log4j.Logger;

import java.util.UUID;
import static entities.Container.decorationList;

public class DecorationRepositoryImpl {

    private final static Logger logger = Logger.getLogger(BaseRepositoryImpl.class);

    public Object getDecorationById(UUID uuid)
    {
        for (int i = 0; i < decorationList.size(); i++)
        {
            if (uuid == decorationList.get(i).getUuid())
            {
                return decorationList.get(i);
            }
        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }

    public void addDecoration(Decoration decoration)
    {
        decorationList.add(decoration);
    }
    public void removeDecoration(Decoration decoration)
    {
        for (int i = 0; i < decorationList.size(); i++)
        {
            if (decoration.equals(decorationList.get(i)))
            {
                decorationList.remove(i);
                break;
            }
        }
    }
    public void updateDecoration(Decoration decoration)
    {
        for (int i = 0; i < decorationList.size(); i++)
        {
            if (decoration.equals(decorationList.get(i)))
            {
                decorationList.set(i, decoration);
                break;
            }
        }
    }
}
