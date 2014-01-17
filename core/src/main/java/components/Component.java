package components;

import event.Message;

/**
 * Created by Edmund on 1/11/14.
 */
public abstract class Component {
    protected GameObject parentObject;

    public void registerParent(GameObject parentObject)
    {
        this.parentObject = parentObject;
    }

    private void sendMessageToParent(Message msg)
    {
        parentObject.relayMessage(msg);
    }

    abstract void receiveMessage(Message msg);
    abstract void update(float dt);
}
