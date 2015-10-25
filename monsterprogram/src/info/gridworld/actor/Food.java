package info.gridworld.actor;

import java.awt.Color;

//A Food
public class Food extends Actor
{
    private static final Color DEFAULT_COLOR = Color.BLACK;

    //Constructs a black rock.
    public Food()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a food of a given color.
    //@param foodColor the color of this food
    public Food(Color foodColor)
    {
        setColor(foodColor);
    }

    //Overrides the act method in the Actor class to do nothing.
    @Override
    public void act()
    {
        
    }
}
