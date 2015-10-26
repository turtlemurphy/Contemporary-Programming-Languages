package info.gridworld.actor;

import java.awt.Color;
import java.util.Random;

//A Zombie is a subclass of Monster
public class Zombie extends Monster
{
    private static final Color DEFAULT_COLOR = Color.GREEN;

    //Constructs a DEFAULT Zombie
    public Zombie()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a Zombie of a given color.
    //@param zombieColor the color of this Zombie
    public Zombie(Color zombieColor)
    {
        setColor(zombieColor);
    }

    //Overrides the act method in the Actor class.
    @Override
    public void act()
    {
        //turnRand is used to give the being a random chance to turn in a 
        //random direction even though the path may be unobstructed
        //Zombies are the worst hunters, their random turn chance is 75%
        Random randomGenerator = new Random();
        int turnRand = randomGenerator.nextInt(1000);
        
        if (turnRand > 250)
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