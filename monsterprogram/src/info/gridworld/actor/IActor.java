package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

//Interface IActor, Implemented by Actor.java
public interface IActor 
{
    Color getColor();
    void setColor(Color newColor);
    int getDirection();
    void setDirection(int newDirection);
    Grid<Actor> getGrid();
    Location getLocation();
    void putSelfInGrid(Grid<Actor> gr, Location loc);
    void removeSelfFromGrid();
    void moveTo(Location newLocation);
    void act();
    String toString();
}
