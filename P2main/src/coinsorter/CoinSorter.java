package coinsorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoinSorter
{
    private List<Integer> coinSortBuffer;
    
    private int[] coinRoller;
    
    private int pennies;
    private int penniesRolls;
    private double penniesTot;
    private int nickels;
    private int nickelsRolls;
    private double nickelsTot;
    private int dimes;
    private int dimesRolls;
    private double dimesTot;
    private int quarters;
    private int quartersRolls;
    private double quartersTot;
    private double sumTot;
    private int subCntr;
    private int coinsInSubset;
    private int csbIndxPH;
    
    File inputFile;
    PrintWriter out;
    
    //Getters-Setters
    public int getPennies()
    {
        return pennies;
    }
    public int getNickels()
    {
        return nickels;
    }
    public int getDimes()
    {
        return dimes;
    }
    public int getQuarters()
    {
        return quarters;
    }
    public int getPenniesRolls()
    {
        return penniesRolls;
    }
    public int getNickelsRolls()
    {
        return nickelsRolls;
    }
    public int getDimesRolls()
    {
        return dimesRolls;
    }
    public int getQuartersRolls()
    {
        return quartersRolls;
    }
    public double getPenniesTot()
    {
        return penniesTot;
    }
    public double getNickelsTot()
    {
        return nickelsTot;
    }
    public double getDimesTot()
    {
        return dimesTot;
    }
    public double getQuartersTot()
    {
        return quartersTot;
    }
    public double getSumTot()
    {
        return sumTot;
    }
    public void setPennies(int num)
    {
       this.pennies = num;
    }
    public void setNickels(int num)
    {
       this.nickels = num;
    }
    public void setDimes(int num)
    {
       this.dimes = num;
    }
    public void setQuarters(int num)
    {
       this.quarters= num;
    }
    
    //Reads in data from the input file and separtates subsets 
    //when it reads a -1
    public void readFile() throws FileNotFoundException, IOException
    {
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
        closeStreams();
        //System.out.print(coinSortBuffer + "\n");
    }
    
    //Moves, Sorts, and organizes all the coins of a given subset
    public void ProcessSubset() throws IOException
    {
        Serialize();
        fillRolls();
        computeTotal();
        writeFile();
        csbIndxPH = csbIndxPH + coinsInSubset; 
        coinsInSubset = 0;
    }
    
    //send the contects of a subset to the coinRolling Array and sorts them
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
    
    //Uses a switch to send the correct coins to the correct roll
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
                        setPennies(0);
                        penniesRolls++;
                    }   
                    break;
                case 5:
                    nickels++;
                    if(nickels == 40)
                    {
                        setNickels(0);
                        nickelsRolls++;
                    }   
                    break;
                case 10:
                    dimes++;
                    if(dimes == 50)
                    {
                        setDimes(0);
                        dimesRolls++;
                    }   
                    break;
                case 25:
                    quarters++;
                    if(quarters == 50)
                    {
                        setQuarters(0);
                        quartersRolls++;
                    }   
                    break;
            }
        }
    }
    
    //Totals all data gathered so far
    public void computeTotal()
    {
        penniesTot = (.50 * penniesRolls) + (pennies * .01);
        nickelsTot = (2.00 * nickelsRolls) + (nickels * .05);
        dimesTot = (5.00 * dimesRolls) + (dimes * .1);
        quartersTot = (10.00 * quartersRolls) + (quarters * .25);
        sumTot = penniesTot + nickelsTot + dimesTot + quartersTot;
    }
    
    //writes the totals ans subtotals to the output file
    public void writeFile() throws FileNotFoundException, IOException
    {
//        System.out.print("After marker: " + subCntr + "\n");
//        System.out.print(penniesRolls + " roll(s) of pennies + " + pennies + " pennies    = $" + penniesTot + "\n");
//        System.out.print(nickelsRolls + " roll(s) of nickels + " + nickels + " nickels    = $" + nickelsTot + "\n");
//        System.out.print(dimesRolls + " roll(s) of dimes + " + dimes + " dimes         = $" + dimesTot + "\n");
//        System.out.print(quartersRolls + " roll(s) of quarters + " + quarters + " quarters   = $" + quartersTot + "\n");
//        System.out.print("Total------------------------------> = $" + sumTot + "\n" + "\n");
        
        out.print("After marker: " + subCntr + "\n");
        out.print(getPenniesRolls() + " roll(s) of pennies + " + getPennies() + " pennies    = $" + penniesTot + "\n");
        out.print(getNickelsRolls()+ " roll(s) of nickels + " + getNickels() + " nickels    = $" + nickelsTot + "\n");
        out.print(getDimesRolls() + " roll(s) of dimes + " + getDimes() + " dimes         = $" + dimesTot + "\n");
        out.print(getQuartersRolls() + " roll(s) of quarters + " + getQuarters() + " quarters   = $" + quartersTot + "\n");
        out.print("Total------------------------------> = $" + sumTot + "\n" + "\n");
    }
    
    //closes output streams
    public void closeStreams()
    {
        out.close();
    }
    
    //Constructor
    public CoinSorter() throws IOException 
    {
        this.inputFile = new File ("G:\\School\\Fall 2015\\Contemporary-Programming-Languages\\P2main\\src\\p2main\\input.txt");
        this.out = new PrintWriter(new FileWriter("G:\\School\\Fall 2015\\Contemporary-Programming-Languages\\P2main\\src\\p2main\\output.txt"));
        
        this.coinSortBuffer  = new ArrayList<>();
        
        pennies = 0;
        penniesRolls = 0;
        penniesTot = 0.0;
    
        nickels = 0;
        nickelsRolls = 0;
        nickelsTot = 0.0;
    
        dimes = 0;
        dimesRolls = 0;
        dimesTot = 0.0;
    
        quarters = 0;
        quartersRolls = 0;
        quartersTot = 0.0;
    
        sumTot = 0.0;
    
        subCntr = 0;
        coinsInSubset = 0;
        csbIndxPH = 0;
    
    }
    
    public static void main(String[] args)
    {
        
        
    }
}
