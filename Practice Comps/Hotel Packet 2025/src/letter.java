import java.util.*;
import java.io.*;
import java.awt.*;

public class letter{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("letter".toLowerCase()+".dat"));
        while(f.hasNext()){
            int letter = 0, digit = 0, other = 0, total = 0;
            String s = f.nextLine().trim();
            for(char c : s.toCharArray()){
                if(Character.isLetter(c)){
                    letter++;
                }
                else if(Character.isDigit(c)){
                    digit++;
                }
                else{
                    other++;
                }
                total++;
            }
            System.out.println(letter+" : "+ digit+" : "+ other+" : "+ total);
        }

        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new letter().run();
    }
}
