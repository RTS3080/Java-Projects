import java.util.*;
import java.io.*;

public class jack{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jack".toLowerCase()+".dat"));
        int i = 1;
        while(f.hasNext()){
            String s = f.nextLine();
            if(i%2==0)
                System.out.println(s);
            i++;

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jack().run();
    }
}
