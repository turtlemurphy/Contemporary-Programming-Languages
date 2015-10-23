////////////////////////////////////////////////////
// Name: Taylor Murphy
// Class : CMPS 4883 Advanced Programing Techniques
// Date : 16 October 2015
// Program 3 - Basic Graphics
////////////////////////////////////////////////////
package shortprog2;

import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class ShortProg2 extends JFrame
{
    public static void main(String[] args)
    {
        FractalTree Frac1 = new FractalTree();
        Frac1.setVisible(true);
    }
}

class FractalTree extends JFrame 
{
    public FractalTree() 
    {
        super("T-Shirt Design");
        
        //set bounds of window
        setBounds(100, 100, 640, 480);
        setResizable(false);
        
        //Colors the background of the Frame maroon
        Color customColor;
        customColor = new Color(128, 0, 0);
        setBackground(customColor);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void drawTree(Graphics g, int x1, int y1, double angle, double depth) 
    {
        //recursivly draws the fractal trees
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 6.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 6.0);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 45, depth - 1);
        drawTree(g, x2, y2, angle + 45, depth - 1);
    }
 
    @Override
    public void paint(Graphics g) 
    {
        //Create color to be applied to the fractals
        Color treeColor = new Color(255,223,0);
        g.setColor(treeColor);
        
        //Draw the Fractals
        drawTree(g, 640,   0,  135, 10);
        drawTree(g,   0,   0,   45, 10);
        drawTree(g, 640, 480, -135, 10);
        drawTree(g,   0, 480,  -45, 10);
        
        //Basic Shape section
        Graphics2D g2 = (Graphics2D)g;
        
        //Set starting pos and dimensions of rectangle 
        double leftX = 215;
        double topY = 180;
        double width = 210;
        double height = 110;
        
        // draw a rectangle
        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.setPaint(Color.BLACK);
        g2.draw(rect);
        
        // draw the enclosed ellipse
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);
        
        //Display the title string
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.setColor(treeColor);
        g.drawString("MSU-ACM", 225, 250);
    }
}