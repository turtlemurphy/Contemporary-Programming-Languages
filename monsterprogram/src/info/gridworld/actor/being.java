package info.gridworld.actor;

import java.awt.Color;

//A being
public class being extends Actor
{
    private static final Color DEFAULT_COLOR = Color.BLACK;

    //Constructs a black being.
    public being()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a being of a given color.
    //@param beingColor the color of this rock
    public being(Color beingColor)
    {
        setColor(beingColor);
    }

    //Overrides the act method in the Actor class to do nothing.
    @Override
    public void act()
    {
        
    }
}