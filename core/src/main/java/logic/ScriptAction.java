package logic;

import main.Main;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.Varargs;

/**
 * ScriptAction is for when we want a Lua script called
 * every tick, and for this to go on until some condition
 * specified by the Lua script
 * Created by Edmund on 1/14/14.
 */
public class ScriptAction extends Action {

    private String functionName;

    public ScriptAction(LuaThread callback, String functionName)
    {
        super(callback);
        this.functionName = functionName;
    }

    public void onStart()
    {

    }

    public void update(float dt)
    {
        Varargs returns = Main.stg.scriptingEngine.callFunction(functionName);
        //I'll finish writing this later...;
    }

}
