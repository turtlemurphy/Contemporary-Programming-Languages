package info.gridworld.actor;

import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

//A Monster is a subclass of being but a parent class of Vampire/Zombie
public class Monster extends being
{
    private static final Color DEFAULT_COLOR = Color.BLACK;

    //Constructs a DEFAULT monster.
    public Monster()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a monster of a given color.
    //@param monsterColor the color of this Monster
    public Monster(Color monsterColor)
    {
        setColor(monsterColor);
    }
    
    //Overrides the act method in the Actor class.
    @Override
    public void act()
    {
        //turnRand is used to give the being a random chance to turn in a 
        //random direction even though the path may be unobstructed
        //Monsters are the average hunters, their random turn chance is 50%
        Random randomGenerator = new Random();
        int turnRand = randomGenerator.nextInt(1000);
        
        if (turnRand > 500)
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