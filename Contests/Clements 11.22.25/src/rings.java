import java.util.*;
import java.io.*;
import java.awt.*;

public class rings{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rings".toLowerCase()+".dat"));
        while(f.hasNext()){
            System.out.println(f.nextLine());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rings().run();
    }
}
