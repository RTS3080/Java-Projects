import java.util.*;
import java.io.*;

public class inbound{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("inbounds".toLowerCase()+".in"));
        String[] str = f.nextLine().split("\\s+");
        System.out.println(str[1].toLowerCase().contains(str[0].toLowerCase())?"YES":"NO");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new inbound().run();
    }
}
