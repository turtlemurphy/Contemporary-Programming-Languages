package info.gridworld.actor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

//A Human is a subclass of being, With the processActors() method the Human 
//roams the grid and performs specific actions based on what 
//actor is encountered 
public class Human extends being
{
    private static final Color DEFAULT_COLOR = Color.WHITE;
    
    //Constructs a Default Human.
    public Human()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a Human of a given color.
    //@param humanColor the color of this Human
    public Human(Color humanColor)
    {
        setColor(humanColor);
    }
    
    //Processes the elements of actors. 
    @Override
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            JOptionPane Frame = new JOptionPane();
            Random randomGenerator = new Random();
            
            if (a instanceof Exit)
            {
                JOptionPane.showMessageDialog(Frame, "The Human has made it to "
                        + "the Exit. YOU WON!!!!");
                a.removeSelfFromGrid();
            }
            else if (a instanceof Food)
            {
                //add to the humans health
                JOptionPane.showMessageDialog(Frame, "The Human has eaten "
                        + "a Food.");
                a.removeSelfFromGrid();
            }
            else if (a instanceof Rock)
            {
                //once human sees a rock one of the squares around the rock 
                //is selected at random
                //the human is teleported to that square and continues moveing 
                //normally after that
            }
            else if (a instanceof Monster)
            {
                int battleOutcome = randomGenerator.nextInt(2);
                
                if (battleOutcome == 0)
                {
                    //Human kills Monster
                    JOptionPane.showMessageDialog(Frame, "The Human has killed "
                            + "a Monster.");
                    a.removeSelfFromGrid();
                }
                else if (battleOutcome == 1)
                {
                    //Monster kills Human
                    JOptionPane.showMessageDialog(Frame, "A Monster has killed "
                            + "the Human. GAME OVER");
                    this.removeSelfFromGrid();
                }
                else if (battleOutcome == 2)
                {
                    //Monster turns Human
                    JOptionPane.showMessageDialog(Frame, "A Monster has turned "
                            + "the Human. GAME OVER");
                    this.removeSelfFromGrid();
                }       
            }
            else if (a instanceof Vampire)
            {
                int battleOutcome = randomGenerator.nextInt(2);
                if (battleOutcome == 0)
                {
                    //Human kills Vamp
                    JOptionPane.showMessageDialog(Frame, "The Human has killed "
                            + "a Vampire.");
                    a.removeSelfFromGrid();
                }
                else if (battleOutcome == 1)
                {
                    //Vamp kills Human
                    JOptionPane.showMessageDialog(Frame, "A Vampire has killed "
                            + "the Human. GAME OVER");
                    this.removeSelfFromGrid();
                }
                else if (battleOutcome == 2)
                {
                    //Vamp turns Human
                    JOptionPane.showMessageDialog(Frame, "A Vampire has turned "
                            + "the Human. GAME OVER");
                    this.removeSelfFromGrid();
                }       
            }
            else if (a instanceof Zombie)
            {
                int battleOutcome = randomGenerator.nextInt(2);
                
                if (battleOutcome == 0)
                {
                    //Human kills Zombie
                    JOptionPane.showMessageDialog(Frame, "The Human has killed "
                            + "a Zombie.");
                    a.removeSelfFromGrid();
                }
                else if (battleOutcome == 1)
                {
                    //Zombie kills Human
                    JOptionPane.showMessageDialog(Frame, "A Zombie has killed "
                            + "the Human. GAME OVER");
                    this.removeSelfFromGrid();
                }
                else if (battleOutcome == 2)
                {
                    //Zombie turns Human
                    JOptionPane.showMessageDialog(Frame, "A Zombie has turned "
                            + "the Human. GAME OVER");
                    this.removeSelfFromGrid();
                }       
            }
        }
    }
    
    //Overrides the act method in the Actor class.
    @Override
    public void act()
    {
        //turnRand is used to give the human a random chance to turn in a random
        //direction even though the path may be unobstructed
        //The Human's primary defense is running away, therefore its random 
        //turn chance is 15%
        Random randomGenerator = new Random();
        int turnRand = randomGenerator.nextInt(1000);
        
        if (turnRand > 850)
        {
            turn();
        }
        else if (canMove())
        {
            processActors(getActors());
            move();
            
        }
        else
        {
            turn();
        }       
    }
}