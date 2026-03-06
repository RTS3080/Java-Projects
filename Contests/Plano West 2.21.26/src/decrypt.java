import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class decrypt{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("decrypt".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        String out = "";
        while(times-->0){
            String line=f.nextLine().trim();
            line = line.substring(1);
            boolean added = false;
            for(char c : line.toCharArray()){
                if(Character.isUpperCase(c)){
                    out+=c;
                    added = true;
                }
            }
            if(added){
                out+=" ";
            }
        }
        System.out.println(out.toLowerCase().trim());
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new decrypt().run();
    }
}
