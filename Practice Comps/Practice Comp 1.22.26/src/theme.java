import java.util.*;
import java.io.*;
import java.awt.*;

public class theme{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("theme".toLowerCase()+".dat"));
        System.out.println("Topeka Crickets (Yahoo)\n" +
                "Topeka Crickets\n" +
                "Topeka Crickets, wooahhh\n" +
                "Topeka Crickets (Topeka Crickets)\n" +
                "Topeka Crickets (Topeka Crickets)\n" +
                "Topeka Crickets (Yeah)\n" +
                "Topeka Crickets (Topeka Crickets, yeah)\n" +
                "Topeka Crickets\n" +
                "Topeka Crickets, wooahhh\n" +
                "Topeka Crickets (Topeka Crickets)\n" +
                "Topeka Crickets (Yahoo)\n" +
                "Topeka Crickets, wooahhh (Listen up)\n" +
                "Topeka Crickets (You'd better beware)\n" +
                "Topeka Crickets (You'd best beware)\n" +
                "Topeka Crickets (We're comin' at you), wooahhh (Topeka Crickets)\n" +
                "Topeka Crickets\n" +
                "Topeka Crickets\n" +
                "Topeka Crickets (Take it home!)\n");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new theme().run();
    }
}
