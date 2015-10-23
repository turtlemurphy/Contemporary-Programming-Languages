////////////////////////////////////////////////////
//Name:       Taylor Murphy
//Class:      CMPS 4143 Contemporary Programming Languages
//Date:       15 September 2015
//Program 1 - Hidden Word
////////////////////////////////////////////////////
/*


*/
package program.pkg1.hidden.word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program1HiddenWord 
{
    public static void main(String[] args) throws IOException
    {
        int wordLen = 0;
        String wordH = null;
        String wordG = null;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter the hidden word in all caps: ");
        wordH = br.readLine();
        
        wordH = wordH.toUpperCase();
        wordLen = wordH.length();
        
        System.out.println("The hidden word is " + wordLen + " letters long");
        
        while (wordG != wordH) 
        {
            System.out.println("Please guess the word: ");
            wordG = br.readLine();
            wordG = wordG.toUpperCase();
            
            System.out.println(wordH + " " + wordG);
            
            System.out.println(wordG == wordH);
            
           
            
        }
        
//        System.out.println("You correctly guessed the hidden word");
//        System.out.println("Hidden Word : " + wordH);
//        System.out.println("Guessed Word: " + wordG);
        
        
        
        
    }
}
