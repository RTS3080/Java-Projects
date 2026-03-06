import java.util.*;
import java.io.*;

public class house{

    public void run() throws FileNotFoundException{

        System.out.println("   ####\n" +
                "  #    #\n" +
                " #      #\n" +
                "#        #\n" +
                "##########\n" +
                "#        #\n" +
                "#  ####  #\n" +
                "#        #\n" +
                "##########");
    }



    public static void main(String[] args) throws FileNotFoundException{
        new house().run();
    }
}
