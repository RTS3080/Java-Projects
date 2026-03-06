import java.util.*;
import java.io.*;

public class canteena{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("canteena".toLowerCase()+".dat"));
        System.out.println("The year is "+f.nextLine());
        System.out.println("We've made official first contact with the "+f.nextLine());
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new canteena().run();
    }
}
