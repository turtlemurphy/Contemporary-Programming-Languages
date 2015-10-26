package info.gridworld.actor;

import java.awt.Color;

//A Rock is an actor that does nothing. It is commonly used to block other actors from moving.
public class Rock extends Actor
{
    private static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;

    //Constructs a black rock.
    public Rock()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a rock of a given color.
    //@param rockColor the color of this rock
    public Rock(Color rockColor)
    {
        setColor(rockColor);
    }

    //Overrides the act method in the Actor class.
    @Override
    public void act()
    {
        
    }
}
