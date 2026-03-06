import java.util.*;
import java.io.*;

public class xmen{

    public void run() throws FileNotFoundException{
        for(int i = 1; i<=10;i++){
            System.out.println(i%10+"-X-MEN");
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new xmen().run();
    }
}
