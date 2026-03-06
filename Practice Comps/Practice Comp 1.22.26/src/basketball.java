import java.util.*;
import java.io.*;
import java.awt.*;

public class basketball{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("basketball".toLowerCase()+".dat"));
        while(f.hasNext()){
            System.out.println(f.nextLine());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new basketball().run();
    }
}
