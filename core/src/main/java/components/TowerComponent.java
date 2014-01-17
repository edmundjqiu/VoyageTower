package components;

import event.Message;

/**
 * Created by Edmund on 1/13/14.
 */
public class TowerComponent extends Component {
    public String towerType;
    public int maxHealth;
    public int currentHealth;
    public boolean isRepairing;
    public boolean isUpgrading;
    public int upgradeBarState;

    public TowerComponent()
    {
        towerType = "BASIC";
        maxHealth = 100;
        currentHealth = 100;
        isRepairing = false;
        isUpgrading = false;
        upgradeBarState = 0;

    }

    public String getTowerType()
    {
        return towerType;
    }

    public void receiveMessage(Message msg)
    {

    }

    public void update(float dt)
    {

    }

}
