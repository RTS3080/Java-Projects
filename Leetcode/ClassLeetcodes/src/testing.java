import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class testing{

    public void run() throws FileNotFoundException{
        for (int i = 0; i <= 360; i++) {
            double y = sin(toRadians(i));
            double x = cos(toRadians(i));
            System.out.printf("%d | x = %.2f, y = %.2f : %.2f\n", i, x, y, acos(y/x));
        }

        byte b = 1;
        b = (byte) ~b;
        System.out.println(Integer.toHexString(b).replaceAll(".+(?>=.{8})", ""));
    }



    public static void main(String[] args) throws FileNotFoundException{
        new testing().run();
    }
}
