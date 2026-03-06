import java.util.*;
import java.io.*;
import java.awt.*;

public class adam{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("adam".toLowerCase()+".dat"));
        while(f.hasNext()){
            System.out.println(f.nextInt()>f.nextInt());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new adam().run();
    }
}
