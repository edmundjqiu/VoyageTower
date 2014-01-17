package scripting;

import com.badlogic.gdx.math.Vector2;
import components.DisplayComponent;
import components.GameObject;
import components.ScriptComponent;
import logic.ObjectFactory;
import logic.WaitAction;
import main.Main;
import main.Stage;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import java.util.ArrayList;

/**
 * Created by Edmund on 1/14/14.
 */
public class GameAPI extends TwoArgFunction {

    public GameAPI()
    {

    }

    public LuaValue call(LuaValue modname, LuaValue env) {
        System.out.println("Setting environment");

        LuaValue library = tableOf();
        library.set( "print", new print() );
        library.set( "wait", new wait() );
        library.set( "newEnemy", new newEnemy() );
        env.set( "GameAPI", library );

        return library;
    }

    static class print extends OneArgFunction {
        public LuaValue call(LuaValue x) {
            System.out.println(x.strvalue());
            return LuaValue.valueOf(0);
        }
    }


    /**
     * Registers an action to wait until the specified amount of time elapses before
     * calling the specified thread to resume.
     */
    static class wait extends ThreeArgFunction {
        public LuaValue call(LuaValue waitDur, LuaValue stageRef, LuaValue callBackThread) {

            Stage stage = (Stage)stageRef.checkuserdata();
            LuaThread callBack = (LuaThread)callBackThread.checkuserdata();

            WaitAction wait = new WaitAction(
                 callBack,
                (float)waitDur.checkdouble()
            );

            stage.actionManager.beginAction(wait);
            stage.scriptingEngine.yieldThread();

            return LuaValue.valueOf(0);
        }
    }


    static class newEnemy extends VarArgFunction {
        public Varargs invoke(Varargs args) {

            //Unbox args
            Vector2 position = new Vector2(
                args.checkint(1),
                args.checkint(2)
            );
            String mainFunctionName = args.checkstring(3).toString();
            Stage stage = (Stage)args.checkuserdata(4);

            //Create the enemy and add it to the stage
            //Please fix this "adding" later
            GameObject o = ObjectFactory.makeEnemy(
                    position,
                    mainFunctionName
            );

            //We didn't add the texture yet
            ((DisplayComponent)o.hasComponent(DisplayComponent.class)).setTexture(
                    stage.enemy
            );

            //Finish puttings things together
            o.registerSelfToComponents();
            stage.objects.add(o);
            stage.componentManager.addAllComponentsOfGameObject(o);

            //Begin script
            ((ScriptComponent)o.hasComponent(ScriptComponent.class)).begin(stage);

            return ScriptingEngine.EMPTY_VARARGS;
        }

    }
}