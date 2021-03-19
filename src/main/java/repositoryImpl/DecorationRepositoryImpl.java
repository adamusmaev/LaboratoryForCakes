package repositoryImpl;

import entities.Decoration;
import java.util.UUID;
import static entities.Container.decorationList;

public class DecorationRepositoryImpl {

    public Object getDecorationById(UUID uuid)
    {
        for (int i = 0; i < decorationList.size(); i++)
        {
            if (uuid == decorationList.get(i).getUuid())
            {
                return decorationList.get(i);
            }
        }
        return new IllegalArgumentException("This id: " + uuid + "not found");
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
