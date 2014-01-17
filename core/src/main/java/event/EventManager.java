package event;

import components.GameObject;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Relays messages to things which are listening for them
 */

public class EventManager {

    private HashMap<String, LinkedList<GameObject>> mapping;

    public EventManager()
    {
        mapping = new HashMap<String, LinkedList<GameObject>>();
    }

    public void registerCategory(String category)
    {
        if (!mapping.containsKey(category))
            mapping.put(category, new LinkedList<GameObject>());
    }

    public void registerObject(GameObject o, String category)
    {
        mapping.get(category).add(o);
    }

    public void relayMessage(Message msg)
    {
        LinkedList<GameObject> list = mapping.get(msg.category);
        for (GameObject o : list)
        {
            o.relayMessage(msg);
        }
    }

}
