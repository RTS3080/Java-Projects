import java.util.*;
import java.io.*;

public class prob09{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        String[] ln = f.nextLine().split(" ");
        String s = "";
        for(String str : ln){
            s+=str.substring(0,1);
        }
        System.out.println(s);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob09().run();
    }
}

