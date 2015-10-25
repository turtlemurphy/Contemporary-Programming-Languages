package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

//A being
public class being extends Actor
{
    private static final Color DEFAULT_COLOR = Color.BLACK;
    
    public int steps;
    public int sideLength;

    //Constructs a black being.
    public being()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a being of a given color.
    //@param beingColor the color of this rock
    public being(Color beingColor)
    {
        setColor(beingColor);
    }
           
    //Tests whether this bug can move forward into a location that is 
    //empty or contains a flower.
    //@return true if this bug can move.
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        
        if (gr == null)
            return false;
        
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        
        if (!gr.isValid(next))
            return false;
        
        Actor neighbor = gr.get(next);
        
         return (neighbor == null);
        // ok to move into empty location
    }
    
    //Turns the bug 45 degrees to the right without changing its location.
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    //Moves the being forward
    public void move()
    {
        Grid<Actor> gr = getGrid();
        
        if (gr == null)
            return;
        
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }

    //Overrides the act method in the Actor class to do nothing.
    @Override
    public void act()
    {
        
    }
}