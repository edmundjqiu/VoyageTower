package logic;

import java.util.LinkedList;

/**
 * Created by Edmund on 1/13/14.
 */
public class ActionManager {

    private LinkedList<Action> currentActions;

    public ActionManager()
    {
        currentActions = new LinkedList<Action>();
    }

    public void beginAction(Action a)
    {
        a.onStart();
        currentActions.add(a);
    }

    //May not be the most efficient way of removing, but...
    public void update(float dt)
    {
        //Should really not make a new list each time...
        LinkedList<Action> removeList = new LinkedList<Action>();

        for (Action a : currentActions)
        {
            a.update(dt);
            if (a.isActionComplete()) removeList.add(a);
        }

        for (Action removedAction : removeList)
        {
            removedAction.onEnd();
            currentActions.remove(removedAction);
        }

    }

}
