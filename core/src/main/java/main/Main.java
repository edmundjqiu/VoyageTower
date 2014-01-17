package main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import event.InputManager;


public class Main extends ApplicationAdapter {

    public static Stage stg;
	
	@Override
	public void create () {
        stg = new Stage();
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        //Shift drawing responsibilities to Stage
        stg.draw();

        //Update
        float dt = Gdx.graphics.getDeltaTime();
        stg.update(dt);

	}



}
