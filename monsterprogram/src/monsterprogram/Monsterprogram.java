////////////////////////////////////////////////////
// Name: Taylor Murphy and Shingai Mapuvire
// Class : CMPS 4883 Advanced Programing Techniques
// Date : 16 October 2015
// Program 3 - Monster World
////////////////////////////////////////////////////
/*
Purpose:
----To create a library (dll) of actors; 
----To design and implement an interface; 
----To instantiate objects of classes in an inheritance hierarchy and 
        polymorphically output each objectâ€™s attributes; 
----To use a variety of GUI components, including a 2-D grid of picture boxes; 
----To use Random method; 
----To use TRUE 2-D arrays and array lists;

Problem:
----Create an interface called IActor. 

----Write an inheritance hierarchy for class 
    Actor
    -Rock
    -Food
    -Being 
    --Human, 
    -Monster
    --Vampire
    --Zombie. 

----Use Actor as the base class of the hierarchy. The private data of Actor 
        should be 
    -an image reference
    -direction
    -location
    -name of the actor. 

----Write a program that: 
    -prompts the user for one of these actors: Rock, Human, 
        Zombie, or Vampire
    -prompts for whether or not they want to use random values for the 
        member data or enter the data
    -displays a picture of the actor in the grid (Put several .gif files 
        in project folder representing various actors.
    -outputs the string representation of the actor
    -moves the actor on the screen


INPUT: 
User should be able to
    -enter the type of actor in a text box (or for 5 extra credit points, 
        select a actor from a combo box - 
        https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
    -indicate if they want to use random values for the member data or 
        enter the member data
    -enter the required data about actors

OUTPUT: 
Output is all done on a form. The form should display
    -a picture of the actor
    -the string representation of the actor
    -an animation of the actor within the world

TURN IN all materials in a 9x12 envelope:
    -1) Print out of documented Source code
    -2) Screen dump(s) of image(s) when running
    -3) Application on some storage media.

*/
package monsterprogram;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Food;
import info.gridworld.actor.Human;
import info.gridworld.actor.Vampire;
import info.gridworld.actor.Zombie;

import java.awt.Color;

public class Monsterprogram 
{
    public static void main(String[] args) 
    {
        ActorWorld world = new ActorWorld();
        
        world.add(new Rock(Color.gray));
        world.add(new Food(Color.ORANGE));
        world.add(new Human(Color.gray));
        world.add(new Vampire(Color.gray));
        world.add(new Zombie(Color.gray));
        
        world.show();
    }
}