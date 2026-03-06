import java.util.*;
import java.io.*;
import java.awt.*;

public class testing{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner("False");
        System.out.println(f.nextBoolean());
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new testing().run();
    }
}
