package repositoryimpl;

import entities.Decoration;
import org.apache.log4j.Logger;

import java.util.UUID;
import static entities.Container.decorationList;

public class DecorationRepositoryImpl {

    private final static Logger logger = Logger.getLogger(DecorationRepositoryImpl.class);

    public Object getDecorationById(UUID uuid)
    {
        for (Decoration d : decorationList)
        {
            if (d.getUuid().equals(uuid))
            {
                return d;
            }
        }
        logger.error("This id: " + uuid + " not found");
        return new IllegalArgumentException();
    }

    public void addDecoration(Decoration decoration)
    {
        decorationList.add(new Decoration(decoration));
        logger.info("Add " + decoration.toString() + " in decorationList");
    }
    public void removeDecoration(Decoration decoration)
    {
        for (Decoration d : decorationList)
        {
            if (decoration.getUuid().equals(d.getUuid()))
            {
                decorationList.remove(d);
            }
        }
        logger.info("Delete " + decoration.toString() + " in decorationList");

    }
    public void updateDecoration(Decoration decoration)
    {
        for (Decoration d : decorationList)
        {
            if (decoration.getUuid().equals(d.getUuid()))
            {
                decorationList.remove(d);
                decorationList.add(decoration);
            }
        }
        logger.info("Update " + decoration.toString() + " in decorationList");
    }
}
