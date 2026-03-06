import java.util.*;
import java.io.*;

public class prob02{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob02".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int vows = 0;
            String s= f.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if(s.substring(i,i+1).matches("[aeiou]")){
                    vows++;
                }
            }
            System.out.println(vows);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob02().run();
    }
}
