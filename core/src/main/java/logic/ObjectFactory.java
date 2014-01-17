package logic;

import com.badlogic.gdx.math.Vector2;
import components.*;

/**
 * Created by Edmund on 1/12/14.
 */
public class ObjectFactory {

    /**
     * Do not actually instantiate this...
     */
    private ObjectFactory() { }

    //Son there is massive duplication of code, consider another function to set up
    //most of the GameObject before having makeTower or makeEnemy finish things off?

    public static GameObject makeTower(Vector2 position, String functionName)
    {
        GameObject obj = new GameObject();

        PhysicsComponent p = new PhysicsComponent();
        p.setPosition(position);
        p.setVelocity(new Vector2(0,0));
        ScriptComponent s = new ScriptComponent();
        TowerComponent t = new TowerComponent();
        DisplayComponent d = new DisplayComponent();

        obj.addComponent(p);
        obj.addComponent(t);
        obj.addComponent(s);
        obj.addComponent(d);
        return obj;
    }

    public static GameObject makeEnemy(Vector2 position, String functionName)
    {
        GameObject obj = new GameObject();

        PhysicsComponent p = new PhysicsComponent();
        p.setPosition(position);
        p.setVelocity(new Vector2(0,0));

        ScriptComponent s = new ScriptComponent();
        s.setMainFunctionName(functionName);

        EnemyComponent e = new EnemyComponent();
        DisplayComponent d = new DisplayComponent();

        obj.addComponent(p);
        obj.addComponent(s);
        obj.addComponent(e);
        obj.addComponent(d);



        return obj;
    }










}
