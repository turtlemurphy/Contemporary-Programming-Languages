package info.gridworld.actor;

import java.awt.Color;

//A Rock is an actor that does nothing. It is used to block other actors from 
//moving. And for the Humans to escape monsters with
public class Rock extends Actor
{
    private static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;

    //Constructs a DEFAULT rock.
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
