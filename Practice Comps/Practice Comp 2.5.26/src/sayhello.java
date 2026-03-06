import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class sayhello{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sayhello".toLowerCase()+".dat"));
        while(f.hasNext()){
            System.out.println(Arrays.stream(f.nextLine().split(" ")).mapToLong(Long::parseLong).sum());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sayhello().run();
    }
}
