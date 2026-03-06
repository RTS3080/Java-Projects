import java.util.*;
import java.io.*;

public class lautaro{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lautaro".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine();
            System.out.println(ln.matches("\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}")?"Valid Phone Number.": "No Calls for You.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lautaro().run();
    }
}
