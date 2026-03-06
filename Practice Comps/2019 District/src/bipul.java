import java.util.*;
import java.io.*;

public class bipul{

    public void run() throws FileNotFoundException{
        System.out.println("|");
        for (int i = 1; i < 9; i+=2) {
            System.out.println("|"+"#".repeat(i)+"\\");
        }
        for (int i = 2; i < 9; i++) {
            System.out.println("|"+"#".repeat(i)+"\\");
        }
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new bipul().run();
    }
}
