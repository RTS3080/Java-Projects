import java.util.*;
import java.io.*;

public class topten{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("topten".toLowerCase()+".dat"));
        String[] ten = new String[10];
        for (int i = 0; i < 10; i++) {
            ten[i] = f.nextLine();
        }
        for(int i = ten.length-1; i >= 0; i--){
            System.out.println(ten[i]);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new topten().run();
    }
}
