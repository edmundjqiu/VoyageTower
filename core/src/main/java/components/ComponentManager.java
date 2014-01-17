package components;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Holds a copy of every component for easy individual updating
 * Created by Edmund on 1/14/14.
 */
public class ComponentManager {

    private HashMap<Class, LinkedList<Component> > mappings;

    public ComponentManager()
    {
        mappings = new HashMap<Class, LinkedList<Component>>();
    }

    public void addComponent(Component c)
    {
        if (mappings.containsKey(c.getClass()))
        {
            mappings.get(c.getClass()).add(c);
        }
        else
        {
            LinkedList<Component> newList = new LinkedList<Component>();
            newList.add(c);
            mappings.put(c.getClass(), newList);
        }
    }

    public void addAllComponentsOfGameObject(GameObject o)
    {
        for (Component c : o.getComponents())
        {
            addComponent(c);
        }
    }

    public LinkedList<Component> getAllComponentsOfClass(Class c)
    {
        return mappings.get(c);
    }

    public void updateComponentsOfClass(Class c, float dt)
    {
        for (Component comp : mappings.get(c))
        {
            comp.update(dt);
        }
    }

}
