package info.gridworld.actor;

import info.gridworld.grid.Location;
import java.awt.Color;

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
        move();
//        //setDirection(getDirection() + Location.HALF_CIRCLE);
//        if (steps < sideLength && canMove())
//        {
//            move();
//            steps++;
//        }
//        else
//        {
//            turn();
//            //turn();
//            steps = 0;
//        }
    }
}