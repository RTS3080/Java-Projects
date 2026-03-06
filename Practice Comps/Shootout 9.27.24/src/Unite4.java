import java.util.*;
import java.io.*;

public class Unite4{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Unite4".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){

        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new Unite4().run();
    }
}
