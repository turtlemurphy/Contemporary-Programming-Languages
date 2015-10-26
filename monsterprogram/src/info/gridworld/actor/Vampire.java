package info.gridworld.actor;

import java.awt.Color;
import java.util.Random;

//A Vampire is a subclass of Monster 
public class Vampire extends Monster
{
    private static final Color DEFAULT_COLOR = Color.RED;

    //Constructs a DEFAULT vampire.
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

    //Overrides the act method in the Actor class.
    @Override
    public void act()
    {
        //turnRand is used to give the being a random chance to turn in a 
        //random direction even though the path may be unobstructed
        //Vamps are the fastest hunters, their random turn chance is 42.5%
        Random randomGenerator = new Random();
        int turnRand = randomGenerator.nextInt(1000);
        
        if (turnRand > 575)
        {
            turn();
        }
        else if (canMove())
        {
            move();
        }
        else
        {
            turn();
        }
    }
}