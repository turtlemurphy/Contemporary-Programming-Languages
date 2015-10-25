package info.gridworld.actor;

import java.awt.Color;

//A Monster
public class Monster extends being
{
    private static final Color DEFAULT_COLOR = Color.BLACK;

    //Constructs a black monster.
    public Monster()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a monster of a given color.
    //@param monsterColor the color of this food
    public Monster(Color monsterColor)
    {
        setColor(monsterColor);
    }

    //Overrides the act method in the Actor class to do nothing.
    @Override
    public void act()
    {
        
    }
}