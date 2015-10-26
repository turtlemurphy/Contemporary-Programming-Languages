////////////////////////////////////////////////////
// Name: Taylor Murphy and Shingai Mapuvire
// Class : CMPS 4883 Advanced Programing Techniques
// Date : 16 October 2015
// Program 5 - Monster Program
////////////////////////////////////////////////////
/*
Program 5 - Monster Program

Turned In:
Source Code 
Screen dumps 
Partner Log
App on storage media
Envelope

*/
package monsterprogram;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Exit;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Food;
import info.gridworld.actor.Human;
import info.gridworld.actor.Monster;
import info.gridworld.actor.Vampire;
import info.gridworld.actor.Zombie;
import info.gridworld.grid.Location;
import javax.swing.JOptionPane;

public class Monsterprogram 
{
    public static void main(String[] args) 
    {
        int userChoice;
        JOptionPane Frame = new JOptionPane();
                        
        String MessageToTheUser = "Please choose. "
                + "Type 0 for a Default instance of the game. "
                + "Type 1 for a Custom instance of the game.";
        
        userChoice = Integer.parseInt(JOptionPane
                .showInputDialog(MessageToTheUser));
        
        //Instantiates actors in 2 different ways, decided by userChoice
        switch (userChoice)
        {
            //Custom Case
            case 1:
                int r;
                int c;
                int actorNum;
                Location actorLoc;
                ActorWorld world = new ActorWorld();
                Exit HumansWin = new Exit();
                
                JOptionPane.showMessageDialog(Frame, "NOTE: When choosing a "
                        + "starting position keep in mind that the maximum "
                        + "coord value is 10");
                
                //Places a Human with a user decided Location
                JOptionPane.showMessageDialog(Frame, "Enter the starting "
                        + "position for the sole Human in the game");
                r = Integer.parseInt(JOptionPane.showInputDialog("Enter the "
                        + "Row Coord"));
                c = Integer.parseInt(JOptionPane.showInputDialog("Enter the "
                        + "Col Coord"));
                actorLoc = new Location(r, c);
                world.add(actorLoc, new Human());
                             
                //asks how many Rock(s) need to be created and give each a user 
                //decided Location
                actorNum = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                        + "the number of Rock(s)"));
                for(int i = 0; i < actorNum; i++)
                {
                    r = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Row Coord for Rock #" + (i+1)));
                    c = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Col Coord for Rock #" + (i+1)));
                    actorLoc = new Location(r, c);
                    world.add(actorLoc, new Rock());
                }
                
                //asks how many Food(s) need to be created and give each a user 
                //decided Location
                actorNum = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                        + "the number of Food(s)"));
                for(int i = 0; i < actorNum; i++)
                {
                    r = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Row Coord for Food #" + (i+1)));
                    c = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Col Coord for Food #" + (i+1)));
                    actorLoc = new Location(r, c);
                    world.add(actorLoc, new Food());
                }
                
                //asks how many Monster(s) need to be created and give each a 
                //user decided Location
                actorNum = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                        + "the number of Monster(s)"));
                for(int i = 0; i < actorNum; i++)
                {
                    r = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Row Coord for Monster #" + (i+1)));
                    c = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Col Coord for Monster #" + (i+1)));
                    actorLoc = new Location(r, c);
                    world.add(actorLoc, new Monster());
                }
                
                //asks how many Vampire(s) need to be created and give each a 
                //user decided Location
                actorNum = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                        + "the number of Vampire(s)"));
                for(int i = 0; i < actorNum; i++)
                {
                    r = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Row Coord for Vampire #" + (i+1)));
                    c = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Col Coord for Vampire #" + (i+1)));
                    actorLoc = new Location(r, c);
                    world.add(actorLoc, new Vampire());
                }
                
                //asks how many Zombie(s) need to be created and give each a 
                //user decided Location
                actorNum = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                        + "the number of Zombie(s)"));
                for(int i = 0; i < actorNum; i++)
                {
                    r = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Row Coord for Zombie #" + (i+1)));
                    c = Integer.parseInt(JOptionPane.showInputDialog("Enter "
                            + "the Col Coord for Zombie #" + (i+1)));
                    actorLoc = new Location(r, c);
                    world.add(actorLoc, new Zombie());
                }
                
                //User has no control over exit, Exit is ramdomly placed on 
                //the board
                world.add(HumansWin);
                
                //Diplays the grid with all of the actors
                world.show();
                
                break;
            
            //Base/Minimium case with every actor having a random 
            //starting location
            default:
                
                world = new ActorWorld();
                HumansWin = new Exit();
                
                world.add(new Rock());
                world.add(new Food());
                world.add(new Human());
                world.add(new Monster());
                world.add(new Vampire());
                world.add(new Zombie());
                
                //User has no control over exit, Exit is ramdomly placed on 
                //the board
                world.add(HumansWin);
                
                //Diplays the grid with all of the actors
                world.show();
                
                break;
        }
    }
}