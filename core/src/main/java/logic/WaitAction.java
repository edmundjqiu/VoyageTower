package logic;

import org.luaj.vm2.LuaThread;

/**
 * Created by Edmund on 1/14/14.
 */
public class WaitAction extends Action {

    private float waitSeconds;
    private float passedTime;

    public WaitAction(LuaThread callback, float waitSeconds)
    {
        super(callback);
        this.waitSeconds = waitSeconds;
        passedTime = 0.0f;
    }

    public void onStart()
    {

    }

    public void update(float dt)
    {
        passedTime += dt;
        if (passedTime >= waitSeconds)
        {
            markActionComplete();
        }
        System.out.println(passedTime);

    }

}
