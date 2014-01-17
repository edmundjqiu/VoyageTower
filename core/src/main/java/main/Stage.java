package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import components.*;
import event.InputManager;
import logic.ActionManager;
import logic.ObjectFactory;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import event.EventManager;
import org.luaj.vm2.LuaThread;
import scripting.ScriptingEngine;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Edmund on 1/12/14.
 */

public class Stage {

    //Managers
    public EventManager eventManager;
    public ActionManager actionManager;
    public ComponentManager componentManager;
    public InputManager inputManager;
    public ScriptingEngine scriptingEngine;

    //Graphics
    public SpriteBatch batch;
    private Texture res;
    public TextureRegion tower;
    public TextureRegion enemy;
    public TextureRegion projectile;
    public Map map;

    //Ugh...
    public static ArrayList<GameObject> objects;

    public Stage()
    {
        //Start managers
        eventManager = new EventManager();
        componentManager = new ComponentManager();
        actionManager = new ActionManager();
        inputManager = new InputManager(this);
        Gdx.input.setInputProcessor(inputManager);


        //This is for rendering
        map = new Map();
        batch = new SpriteBatch();

        //For the sake of testing, just load a handful of images.
        res = new Texture("res1.png");
        tower = new TextureRegion(res, 100, 150, 50, 50);
        enemy = new TextureRegion(res, 255, 50, 50, 50);
        projectile = new TextureRegion(res, 203, 255, 25, 25);

        //Container for all objects... this will be changed later to just be
        //for components or something
        objects = new ArrayList<GameObject>();

        //Set up scripting
        scriptingEngine = new ScriptingEngine();
        scriptingEngine.loadScript("core.lua");
        scriptingEngine.loadScript("test.lua");
        scriptingEngine.loadScript("level1.lua");

        //Let all of Lua know the Stage
        scriptingEngine.callFunction("registerStage",
            ScriptingEngine.objectsToLuaValues(
                new Object[] {
                    this
                }
            )
        );

        //Level-thread begin
        LuaThread t = scriptingEngine.createThread("levelAction");
        t.resume(ScriptingEngine.objectsToVarargs(
                new Object[] { t }
        ));


    }

    public void update(float dt)
    {
        actionManager.update(dt);
        map.update(dt);

    }

    public void draw()
    {


        map.draw();

        batch.begin();
        //batch.draw(res, 50, 0);
//        batch.draw(tower, 50, 50);
//        batch.draw(enemy, 250, 50);
//        batch.draw(projectile, 170, 50);

        //Draw all DisplayComponents
        LinkedList<Component> display = componentManager.getAllComponentsOfClass(
                DisplayComponent.class);
        for (Component d : display)
        {
            ((DisplayComponent)d).draw(batch);
        }




        batch.end();
    }

}
