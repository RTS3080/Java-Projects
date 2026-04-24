import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class pals{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("pals".toLowerCase()+".txt"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        loop:
        for(int times = 0; times < numTimes; times++){
            String s = f.next();
            if(isPal(s)){
                System.out.println("The string is already a palindrome");
                continue loop;
            }
            for (int i = 0; i < s.length(); i++) {
                if(isPal(s.substring(0, i)+s.substring(i+1))){
                    System.out.println("A palindrome can be formed by deleting the letter in position "+(i+1));
                    continue loop;
                }
            }
            System.out.println("A palindrome cannot be formed by deleting a single letter");



        }
        f.close();
    }
    boolean isPal(String s){
        StringBuilder sb = new StringBuilder(s);
//        System.out.println(sb.reverse()+" "+s);
        return sb.reverse().toString().equals(s);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new pals().run();
    }
}
