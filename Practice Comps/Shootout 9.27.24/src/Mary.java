import java.util.*;
import java.io.*;

public class Mary{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Mary".toLowerCase()+".dat"));
        while(f.hasNext()) {
            System.out.println(f.nextLine());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Mary().run();
    }
}
