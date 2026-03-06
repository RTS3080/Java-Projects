import java.util.*;
import java.io.*;
import java.awt.*;

public class anastasia{

    public void run() throws FileNotFoundException {
//        int[] arr = Arrays.stream("400 361 324 289 256 196 169 144 121 100 81 64 49 36 25 19 9 4 1 0".split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i =20; i>=0;i--){
            System.out.println("The square root of " + i*i + " is " + i+".");
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new anastasia().run();
    }
}
