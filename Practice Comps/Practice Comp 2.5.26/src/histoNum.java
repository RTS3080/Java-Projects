import java.util.*;
import java.io.*;


public class histoNum{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("histoNum".toLowerCase()+".dat"));
        int[] counts = new int[10];
        while(f.hasNext()){
            char[] ln = f.next().toCharArray();
            for(char c : ln){
                if(Character.isDigit(c)){
                    counts[c-'0']++;
                }
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == 0){
                continue;
            }
            System.out.println(i+"|"+("*").repeat(counts[i]));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new histoNum().run();
    }
}
