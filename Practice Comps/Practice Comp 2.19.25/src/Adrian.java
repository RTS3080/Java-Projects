import java.util.*;
import java.io.*;

public class Adrian{

    public void run() throws FileNotFoundException{
        String s ="JAVA PYTHON SWIFT ADA C C++ COBOL FORTRAN ALGOL BASIC DELPHI PASCAL PL1 JAVASCRIPT";
        for(String str : s.split(" ")){
            System.out.println(str);
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Adrian().run();
    }
}
