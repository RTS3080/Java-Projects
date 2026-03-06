import java.util.*;
import java.io.*;

public class ankur{

    public void run() throws FileNotFoundException{
        double p = Math.PI * 1000;
        double e = Math.E * 100;
        System.out.printf("%.2f\n%.6f\n3.141593e+03\n%.3f\n%.6f\n2.718282e+02",p,p,e,e);
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ankur().run();
    }
}
