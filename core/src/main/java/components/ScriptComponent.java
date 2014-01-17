package components;

import event.Message;
import main.Main;
import main.Stage;
import org.luaj.vm2.LuaThread;
import scripting.ScriptingEngine;

/**
 * Created by Edmund on 1/12/14.
 */
public class ScriptComponent extends Component {

    private String mainFunctionName;

    public ScriptComponent()
    {

    }

    public void setMainFunctionName(String mainFunctionName)
    {
        this.mainFunctionName = mainFunctionName;
    }

    public void begin(Stage s)
    {
        LuaThread t = s.scriptingEngine.createThread(mainFunctionName);
        t.resume(ScriptingEngine.objectsToVarargs(new Object[] { t , this } ));
    }

    public void receiveMessage(Message msg)
    {

    }

    public void update(float dt)
    {

    }

}
