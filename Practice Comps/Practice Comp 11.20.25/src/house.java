import java.util.*;
import java.io.*;
import java.awt.*;

public class house{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("house".toLowerCase()+".dat"));
        while(f.hasNext()){
            System.out.println(f.nextLine());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new house().run();
    }
}
