package info.gridworld.actor;

import java.awt.Color;

//A Food is a subclass of Actor, A Food object serves to give the human more 
//health when it is encountered by the human 
public class Food extends Actor
{
    private static final Color DEFAULT_COLOR = Color.WHITE;

    //Constructs a DEFAULT Food.
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

    //Overrides the act method in the Actor class.
    @Override
    public void act()
    {
        
    }
}
