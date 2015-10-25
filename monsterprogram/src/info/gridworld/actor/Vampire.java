package info.gridworld.actor;

import java.awt.Color;

//A Vampire
public class Vampire extends Monster
{
    private static final Color DEFAULT_COLOR = Color.BLACK;

    //Constructs a black vampire.
    public Vampire()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a vampire of a given color.
    //@param vampireColor the color of this food
    public Vampire(Color vampireColor)
    {
        setColor(vampireColor);
    }

    //Overrides the act method in the Actor class to do nothing.
    @Override
    public void act()
    {
        
    }
}