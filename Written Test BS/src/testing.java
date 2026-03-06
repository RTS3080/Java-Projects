import java.util.*;
import java.io.*;
import java.awt.*;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class testing{

    public void run() throws FileNotFoundException{
        A B = new B();
        A.sout();

        //-------------//
        testing.B.sout();
        testing.A.sout();
    }
    class A{
        static void sout(){
            out.println("abbi");
        }
    }
    class B extends A{
        static void sout(){
            out.println("woah!");
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new testing().run();
    }
}
