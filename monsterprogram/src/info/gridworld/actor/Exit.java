package info.gridworld.actor;

import java.awt.Color;
import javax.swing.JOptionPane;

//A Exit is the object that the human needs to get to in order to win
public class Exit extends Actor
{
    private static final Color DEFAULT_COLOR = Color.DARK_GRAY;
    
    //Constructs an Exit
    //Will be placed randomly in the grid
    //Acts like Food but consuming Exit wins the game for the human
    public Exit()
    {
        setColor(DEFAULT_COLOR);
        
    }
    
    //Overrides the act method in the Actor class.
    @Override
    public void act()
    {
        
    }
}
