package info.gridworld.actor;

import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.Random;

//A Human
public class Human extends being
{
    private static final Color DEFAULT_COLOR = Color.WHITE;
    
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
    
    //Overrides the act method in the Actor class.
    @Override
    public void act()
    {
        //turnRand is used to give the human a random chance to turn in a random direction even though the path may be unobstructed
        //The Human's primary defense is running away, therefore their random turn chance is 15%
        Random randomGenerator = new Random();
        int turnRand = randomGenerator.nextInt(1000);
        
        if (turnRand > 850)
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