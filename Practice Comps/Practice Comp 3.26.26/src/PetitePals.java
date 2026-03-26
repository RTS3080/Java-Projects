import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class PetitePals{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("PetitePals".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String s = f.next().toUpperCase();
            HashSet<String> pals = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i+1; j <= s.length(); j++) {
                    if(isPal(s.substring(i, j))){
                        pals.add(s.substring(i, j));
                    }
                }
            }
            int change = 0;
            if(isPal(s) && !pals.isEmpty()){
                change = -1;
            }
            System.out.println(pals.size()+change);
        }
        f.close();
    }
    boolean isPal(String s){
        if(s.length()%2==0){
            String start = s.substring(0, s.length()/2);
            String end = new StringBuilder(s.substring(s.length()/2)).reverse().toString();
            return start.equals(end);
        }
        String start = s.substring(0, s.length()/2);
        String end = new StringBuilder(s.substring(s.length()/2+1)).reverse().toString();
        return start.equals(end);
    }



    public static void main(String[] args) throws FileNotFoundException{
        new PetitePals().run();
    }
}
