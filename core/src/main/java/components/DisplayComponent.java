package components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import event.Message;

/**
 * Created by Edmund on 1/15/14.
 */
public class DisplayComponent extends Component {

    private TextureRegion texture;

    public DisplayComponent()
    {

    }

    public void setTexture(TextureRegion texture)
    {
        this.texture = texture;
    }

    public void update(float dt)
    {
        //For updating any animations in future
    }

    public void receiveMessage(Message msg)
    {

    }

    public void draw(SpriteBatch batch, PhysicsComponent physics)
    {
        Vector2 pos = physics.getPosition();
        batch.draw(texture, pos.x, pos.y);
    }


    public void draw(SpriteBatch batch)
    {
        PhysicsComponent physics = (PhysicsComponent)parentObject.hasComponent(
                PhysicsComponent.class);
        draw(batch, physics);
    }

}
