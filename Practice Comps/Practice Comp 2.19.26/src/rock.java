import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class rock{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rock".toLowerCase()+".dat"));
        HashMap<Character, Character> beats = new HashMap<>();
        beats.put('R', 'P');
        beats.put('P', 'S');
        beats.put('S', 'R');
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            char[] ln = f.nextLine().trim().toCharArray();
            char opponent = 'R';
            int win = 0;
            int loss = 0;
            int tie = 0;
            for(char c: ln){
                if(c == opponent)
                    tie++;
                else if(beats.get(c) == opponent){
                    loss++;
                }
                else if(beats.get(opponent) == c){
                    win++;
                    opponent = beats.get(c);
                }
            }
            System.out.println("Wins: "+win+"\nLosses: "+loss+"\nTies: "+tie);
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rock().run();
    }
}
