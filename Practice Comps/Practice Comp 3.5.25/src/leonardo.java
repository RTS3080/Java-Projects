import java.util.*;
import java.io.*;

public class leonardo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("leonardo".toLowerCase()+".dat"));
        while(f.hasNext()){
            String[] split = f.nextLine().split("\\s+=\\s+");
            String[] name = split[0].split("\\s+");
            String[] real = split[1].split("\\s+");
            String n = "";
            String r = "";
            for(String s : name){
                n+=s.substring(0,1).toUpperCase();
            }
            for(String s : real){
                r+=s.substring(s.length()-1).toUpperCase();
            }
            System.out.println(n+" = " +r);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new leonardo().run();
    }
}
