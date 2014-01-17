package event;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import main.Stage;

/**
 * Created by Edmund on 1/15/14.
 */
public class InputManager implements InputProcessor {

    public Stage currentStage;

    public InputManager(Stage currentStage)
    {
        this.currentStage = currentStage;
    }

    @Override
    public boolean keyDown(int keycode) {
//        float moveAmount = 1.0f;
//
//        if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
//
//        if(keycode == Keys.RIGHT)
        System.out.println(keycode);

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX + " , " + screenY);

        if(button == Input.Buttons.LEFT){

        }
        if(button == Input.Buttons.RIGHT){

        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        System.out.println("!!");
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
