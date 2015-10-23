package tester;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester
{
    private List<Integer> coinSortBuffer  = new ArrayList<>();
    
    private int[] coinRoller;
    
    private int pennies = 0;
    private int penniesRolls = 0;
    private double penniesTot = 0;
    private int nickels = 0;
    private int nickelsRolls = 0;
    private double nickelsTot = 0;
    private int dimes = 0;
    private int dimesRolls = 0;
    private double dimesTot = 0;
    private int quarters = 0;
    private int quartersRolls = 0;
    private double quartersTot = 0;
    private double sumTot = 0;
    
    private int subCntr = 0;
    private int coinsInSubset = 0;
    private int csbIndxPH = 0;
    
    private int coinChecker = 0;
    
    public Tester() 
    {
    
    }
    
    public void readFile() throws FileNotFoundException, IOException
    {
        File inputFile = new File ("G:\\School\\Fall 2015\\Contemporary-Programming-Languages\\tester\\src\\tester\\input.txt");
        Scanner scan = new Scanner(inputFile);
        
        while(scan.hasNext()) 
        {
            int coin = scan.nextInt();
            
            if(coin == -1)
            {
                subCntr++;
                ProcessSubset();
            }
            else
            {
                //add to array list
                coinSortBuffer.add(coin);
                coinsInSubset++;
            }
        }
        //System.out.print(coinSortBuffer + "\n");
    }
    
    public void ProcessSubset() throws IOException
    {
        Serialize();
        fillRolls();
        computeTotal();
        writeFile();
        csbIndxPH = csbIndxPH + coinsInSubset; 
        coinsInSubset = 0;
    }
    
    public void Serialize()
    {
        coinRoller = new int[coinsInSubset];
        for(int i = 0; i < coinsInSubset; i++)
        {
            coinRoller[i] = 0;
        }
        
        for(int i = 0; i < coinsInSubset; i++)
        {
            coinRoller[i] = coinSortBuffer.get(csbIndxPH + i);
        }
        Arrays.sort(coinRoller);
        //for(int i = 0; i < coinsInSubset; i++)
        //{
        //System.out.print(coinRoller[i] + "");
        //}
        //System.out.print("\n");
    }
    
    public void fillRolls()
    {
        for(int i = 0; i < coinsInSubset; i++)
        {
            switch (coinRoller[i]) 
            {
                case 1:
                    pennies++;
                    if(pennies == 50)
                    {
                        pennies = 0;
                        penniesRolls++;
                    }   
                    break;
                case 5:
                    nickels++;
                    if(nickels == 40)
                    {
                        nickels = 0;
                        nickelsRolls++;
                    }   
                    break;
                case 10:
                    dimes++;
                    if(dimes == 50)
                    {
                        dimes = 0;
                        dimesRolls++;
                    }   
                    break;
                case 25:
                    quarters++;
                    if(quarters == 50)
                    {
                        quarters = 0;
                        quartersRolls++;
                    }   
                    break;
            }
        }
    }
    
    public void computeTotal()
    {
        penniesTot = (.50 * penniesRolls) + (pennies * .01);
        nickelsTot = (2.00 * nickelsRolls) + (nickels * .05);
        dimesTot = (5.00 * dimesRolls) + (dimes * .1);
        quartersTot = (10.00 * quartersRolls) + (quarters * .25);
        sumTot = penniesTot + nickelsTot + dimesTot + quartersTot;
    }
    
    public void writeFile() throws FileNotFoundException, IOException
    {
        PrintWriter out = new PrintWriter(new FileWriter("G:\\School\\Fall 2015\\Contemporary-Programming-Languages\\CoinSorter\\src\\coinsorter\\output.txt"));
        
        //Output file in --> Prog2CoinSorter\\src\\prog2coinsorter\\output.txt
        
        System.out.print("After marker: " + subCntr + "\n");
        System.out.print(penniesRolls + " roll(s) of pennies + " + pennies + " pennies    = $" + penniesTot + "\n");
        System.out.print(nickelsRolls + " roll(s) of nickels + " + nickels + " nickels    = $" + nickelsTot + "\n");
        System.out.print(dimesRolls + " roll(s) of dimes + " + dimes + " dimes         = $" + dimesTot + "\n");
        System.out.print(quartersRolls + " roll(s) of quarters + " + quarters + " quarters   = $" + quartersTot + "\n");
        System.out.print("Total---------------------------------> = $" + sumTot + "\n" + "\n");
        
        
        
        out.close();
        
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Tester test = new Tester();
        
        test.readFile();
        
    }   
}
