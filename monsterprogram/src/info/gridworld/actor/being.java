package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

//A being is a subclass of Actor but a parent class to 
//Humans/Monsters/Vamps/Zombies.
public class being extends Actor
{
    private static final Color DEFAULT_COLOR = Color.BLACK;
    
    //Constructs a DEFAULT being.
    public being()
    {
        setColor(DEFAULT_COLOR);
    }

    //Constructs a being of a given color.
    //@param beingColor the color of this being
    public being(Color beingColor)
    {
        setColor(beingColor);
    }
           
    //Tests whether this bug can move forward into a location that is empty
    //@return true if this being can move.
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
    
    //Turns the being 90 degrees to the right without changing its location.
    public void turn()
    {   
        //uses random to decide what direction the being will turn when 
        //encountered with an obstacle
        Random randomGenerator = new Random();
        int turn = randomGenerator.nextInt(2);
        
        int turnDirection = 0;
               
        if(turn == 0)
        {
            turnDirection = Location.RIGHT;
        }
        else if(turn == 1)
        {
            turnDirection = Location.LEFT;
        }
        else
        {
            turnDirection = Location.HALF_CIRCLE;
        }
        
        setDirection(getDirection() + turnDirection);
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
    
    //Gets the actors for processing.
    //Postcondition: The state of all actors is unchanged.
    //@return a list of actors that this critter wishes to process.
    public ArrayList<Actor> getActors()
    {
        return getGrid().getNeighbors(getLocation());
    }
    
    //Processes the elements of actors. Override this method in subclasses to 
    //process actors in a different way.
    public void processActors(ArrayList<Actor> actors)
    {
    
    }
    
    //Overrides the act method in the Actor class.
    @Override
    public void act()
    {
        
    }
}