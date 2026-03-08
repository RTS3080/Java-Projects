import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob09{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob09".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        int shift = f.nextInt();
        f.nextLine();
        String ln= f.nextLine().trim();
        char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String out = "";
        for(String s : ln.split(" ")) {
            for (char c : s.toCharArray()) {
                if (!Character.isLetter(c) || Character.isSpaceChar(c) || Character.isDigit(c)) {
                    out += c;
                    continue;
                }
                int start = 0;
                if (Character.isUpperCase(c)) {
                    start = c - 'A';
                } else {
                    start = c - 'a';
                }
                start += shift;
                start %= 26;
                if (Character.isUpperCase(c)) {
                    out += (char) ('A' + start);
                } else {
                    out += (char) ('a' + start);
                }
            }
            out+=" ";
        }
        System.out.println(out.trim());
        f.close();
    }




    public static void main(String[] args) throws FileNotFoundException{
        new prob09().run();
    }
}
