import java.util.*;
import java.io.*;

public class mutiny{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mutiny".toLowerCase()+".dat"));
        int numPirates = f.nextInt();
        int maxStrength = f.nextInt();
        for (int i = 0; i < numPirates; i++) {

        }
        f.close();
    }


    
    public static void main(String[] args) throws FileNotFoundException{
        new mutiny().run();
    }
}
