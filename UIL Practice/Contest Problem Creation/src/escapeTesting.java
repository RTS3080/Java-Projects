import java.util.*;
import java.io.*;
import java.awt.*;


public class escapeTesting{

    public void run() throws FileNotFoundException{
        greatEscape.Sphere s = new greatEscape.Sphere(0,2,2,2,1,.5);
        System.out.println(s.intersectsWall(2, 15, 10,10,10));
    }



    public static void main(String[] args) throws FileNotFoundException{
        new escapeTesting().run();
    }
}
