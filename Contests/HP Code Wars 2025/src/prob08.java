import java.util.*;
import java.io.*;

public class prob08{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        String s= f.nextLine().trim();
        String l = f.nextLine().trim();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.toLowerCase().substring(i,i+1).equalsIgnoreCase(l)){
                count++;
            }
        }
        System.out.println("There are "+count+" "+l.toUpperCase()+"'s in "+s);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob08().run();
    }
}
