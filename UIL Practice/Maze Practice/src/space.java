import java.util.*;
import java.io.*;

public class space{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("space".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n = f.nextInt();
            int s = f.nextInt();

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new space().run();
    }
}
