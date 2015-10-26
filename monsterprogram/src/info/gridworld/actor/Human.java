package info.gridworld.actor;

import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.Random;

//A Human
public class Human extends being
{
    private static final Color DEFAULT_COLOR = Color.BLACK;
    
    //Constructs a black Human.
    public Human()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a Human of a given color.
    //@param humanColor the color of this food
    public Human(Color humanColor)
    {
        setColor(humanColor);
    }
    
    //Overrides the act method in the Actor class to do nothing.
    @Override
    public void act()
    {
        //turnRand is used to give the human a random chance to turn in a random direction even though the path may be unobstructed
        Random randomGenerator = new Random();
        int turnRand = randomGenerator.nextInt(1000);
        
        if (turnRand > 700)
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