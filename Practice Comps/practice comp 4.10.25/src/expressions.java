import java.util.*;
import java.io.*;

public class expressions{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("expressions".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new expressions().run();
    }
}
