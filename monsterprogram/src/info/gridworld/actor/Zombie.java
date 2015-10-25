package info.gridworld.actor;

import java.awt.Color;

//A Zombie
public class Zombie extends Monster
{
    private static final Color DEFAULT_COLOR = Color.BLACK;

    //Constructs a black rock.
    public Zombie()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a Zombie of a given color.
    //@param zombieColor the color of this food
    public Zombie(Color zombieColor)
    {
        setColor(zombieColor);
    }

    //Overrides the act method in the Actor class to do nothing.
    @Override
    public void act()
    {
        
    }
}