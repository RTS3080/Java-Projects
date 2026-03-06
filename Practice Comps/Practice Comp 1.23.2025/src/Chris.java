import java.util.*;
import java.io.*;

public class Chris{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Chris".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long size = f.nextLong();
            f.nextLine();
            long c = 0;
            for (long i = 0; i < size; i++) {
                String line = f.nextLine();
                for (char ch : line.toCharArray()) {
                    if (ch == '*') c++;
                }
            }
            System.out.println("$" + c * 150);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Chris().run();
    }
}
