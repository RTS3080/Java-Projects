import java.util.*;
import java.io.*;

public class anisha{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("anisha".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int n=f.nextInt();
            int m = f.nextInt();
            if(n>=15) System.out.println("Way to go, H2O.");
            else System.out.println("On my way, to Dehydration Station.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new anisha().run();
    }
}
