import java.util.*;
import java.io.*;

public class karen{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("karen".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int a=f.nextInt();
            a=(int)(Math.round(Math.sqrt(a)));
            System.out.println(a*a);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new karen().run();
    }
}

