////////////////////////////////////////////////////
// Name: Taylor Murphy
// Class : CMPS 4883 Advanced Programing Techniques
// Date : 16 October 2015
// Program 3 - Monster World
////////////////////////////////////////////////////
/*
Purpose:
----To create a library (dll) of actors; 
----To design and implement an interface; 

----To instantiate objects of classes in an inheritance hierarchy and 
    polymorphically output each object’s attributes; 

----To use a variety of GUI components, including a 2-D grid of picture boxes; 
----To use Random method; 
----To use TRUE 2-D arrays and array lists;

Problem:
----Create an interface called IActor. 

----Write an inheritance hierarchy for class Actor, Rock, Food, Being, Human, 
    and Monster, Vampire, Zombie. 

----Use Actor as the base class of the hierarchy. The private data of Actor 
    should be an image reference, direction, location, and name of the actor. 

----Write a program that: 
         prompts the user for one of these actors: Rock, Human, 
            Zombie, or Vampire
         prompts for whether or not they want to use random values for the 
            member data or enter the data
         displays a picture of the actor in the grid (Put several .gif files 
            in project folder representing various actors.
         outputs the string representation of the actor
         moves the actor on the screen


INPUT: 
User should be able to
     enter the type of actor in a text box (or for 5 extra credit points, select a actor from a combo box - https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html)
     indicate if they want to use random values for the member data or enter the member data
     enter the required data about actors

OUTPUT: 
Output is all done on a form. The form should display
     a picture of the actor
     the string representation of the actor
     an animation of the actor within the world

TURN IN all materials in a 9x12 envelope:
1) Print out of documented Source code
2) Screen dump(s) of image(s) when running
3) Application on some storage media.

*/
package monsterprogram;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;


public class Monsterprogram 
{
    public static void main(String[] args) 
    {
        ActorWorld world = new ActorWorld();
       
        
        world.show();
    }
    
    //An Actor is an entity with a color and direction that can act.
    public class Actor
    {
        private Grid<Actor> grid;
        private Location location;
        private int direction;
        private Color color;

        //Constructs a blue actor that is facing north.
        public Actor()
        {
            color = Color.BLUE;
            direction = Location.NORTH;
            grid = null;
            location = null;
        }

        //Gets the color of this actor.
        //@return the color of this actor
        public Color getColor()
        {
            return color;
        }

        //Sets the color of this actor.
        //@param newColor the new color
        public void setColor(Color newColor)
        {
            color = newColor;
        }

        //Gets the current direction of this actor.
        //@return the direction of this actor, an angle between 0 and 359 degrees
        public int getDirection()
        {
            return direction;
        }

        //Sets the current direction of this actor.
        //@param newDirection the new direction. The direction of this actor 
        //is set to the angle between 0 and 359 degrees that is equivalent 
        //to newDirection.
        public void setDirection(int newDirection)
        {
            direction = newDirection % Location.FULL_CIRCLE;
            
            if (direction < 0)
                direction += Location.FULL_CIRCLE;
        }

        //Gets the grid in which this actor is located.
        //@return the grid of this actor, or null if this actor is not contained in a grid
        public Grid<Actor> getGrid()
        {
            return grid;
        }

        //Gets the location of this actor.
        //@return the location of this actor, or null if this actor is not contained in a grid
        public Location getLocation()
        {
            return location;
        }

        //Puts this actor into a grid. If there is another actor at the given location, it is removed.
        //Precondition: 
        //(1) This actor is not contained in a grid 
        //(2) loc is valid in gr
        //@param gr the grid into which this actor should be placed
        //@param loc the location into which the actor should be placed
        public void putSelfInGrid(Grid<Actor> gr, Location loc)
        {
            if (grid != null)
                throw new IllegalStateException("This actor is already contained in a grid.");

            Actor actor = gr.get(loc);
            
            if (actor != null)
                actor.removeSelfFromGrid();
            
            gr.put(loc, this);
            grid = gr;
            location = loc;
        }

        //Removes this actor from its grid.
        //Precondition: This actor is contained in a grid
        public void removeSelfFromGrid()
        {
            if (grid == null)
                throw new IllegalStateException("This actor is not contained in a grid.");
            
            if (grid.get(location) != this)
                throw new IllegalStateException("The grid contains a different actor at location " + location + ".");

            grid.remove(location);
            grid = null;
            location = null;
        }

        //Moves this actor to a new location. If there is another actor at the given location, it is removed.
        //Precondition: 
        //(1) This actor is contained in a grid
        //(2) newLocation is valid in the grid of this actor
        //@param newLocation the new location
        public void moveTo(Location newLocation)
        {
            if (grid == null)
                throw new IllegalStateException("This actor is not in a grid.");
            
            if (grid.get(location) != this)
                throw new IllegalStateException("The grid contains a different actor at location " + location + ".");
            
            if (!grid.isValid(newLocation))
                throw new IllegalArgumentException("Location " + newLocation + " is not valid.");

            if (newLocation.equals(location))
                return;
        
            grid.remove(location);
            Actor other = grid.get(newLocation);
            
            if (other != null)
                other.removeSelfFromGrid();
        
            location = newLocation;
            grid.put(location, this);
        }

        //Reverses the direction of this actor. Override this method in subclasses of Actor to define types of actors with different behavior
        public void act()
        {
            setDirection(getDirection() + Location.HALF_CIRCLE);
        }

        //Creates a string that describes this actor.
        //@return a string with the location, direction, and color of this actor
        public String toString()
        {
            return getClass().getName() + "[location=" + location + ",direction=" + direction + ",color=" + color + "]";
        }
    }
    
    //A Rock is an actor that does nothing. It is commonly used to block other actors from moving.
    public class Rock extends Actor
    {
        private Color DEFAULT_COLOR = Color.BLACK;

        //Constructs a black rock.
        public Rock()
        {
            setColor(DEFAULT_COLOR);
        }
        
        //Constructs a rock of a given color.
        //@param rockColor the color of this rock
        public Rock(Color rockColor)
        {
            setColor(rockColor);
        }

        // Overrides the act method in the Actor class to do nothing.
        @Override
        public void act()
        {
        
        }
    }
    
    //A Food 
    public class Food extends Actor
    {
        
    }
    
    //A Being 
    public class Being extends Actor
    {
        
    }
    
    //A Human 
    public class Human extends Being
    {
        
    }
    
    //A Monster 
    public class Monster extends Being
    {
        
    }
    
    //A Vampire 
    public class Vampire extends Being
    {
        
    }
    
    //A Zombie 
    public class Zombie extends Being
    {
        
    }
    
    
}
