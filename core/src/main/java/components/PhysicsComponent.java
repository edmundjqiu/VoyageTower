package components;

import com.badlogic.gdx.math.Vector2;

import event.Message;

/**
 * The physical representation of the object in 2D space
 * Created by Edmund on 1/12/14.
 */

public class PhysicsComponent extends Component {

    private Vector2 pos;
    private Vector2 velocity;

    public PhysicsComponent()
    {

    }

    public void setPosition(Vector2 pos)
    {
        this.pos = pos;
    }

    public void setVelocity(Vector2 velocity)
    {
        this.velocity = velocity;
    }

    public Vector2 getPosition()
    {
        return pos;
    }

    public Vector2 getVelocity()
    {
        return velocity;
    }

    public void update(float dt)
    {
        Vector2 dv = velocity.scl(dt);
        pos = pos.add(dv);
    }

    public void receiveMessage(Message msg)
    {

    }

}
