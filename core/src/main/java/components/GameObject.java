package components;

import event.Message;
import main.Main;
import main.Stage;

import java.util.LinkedList;

/**
 * Created by Edmund on 1/11/14.
 */
public class GameObject {

    private LinkedList<Component> components;

    public GameObject()
    {
        components = new LinkedList<Component>();
    }

    public LinkedList<Component> getComponents()
    {
        return components;
    }

    public void addComponent(Component c)
    {
        components.add(c);
    }

    public Component hasComponent(Class componentClass)
    {
        for (Component component : components)
        {
            if (componentClass.isInstance(component))
                return component;
        }
        System.out.println("asdf");
        return null;
    }

    public void registerSelfToComponents()
    {
        for (Component component : components)
        {
            component.registerParent(this);
        }
    }

    /**
     * Relays the message to each of this GameObject's components
     * @param msg the message to be relayed
     */
    public void relayMessage(Message msg)
    {
        for (Component c : components)
        {
            c.receiveMessage(msg);
        }
    }
}
