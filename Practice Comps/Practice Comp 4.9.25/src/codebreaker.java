import java.util.*;
import java.io.*;

public class codebreaker{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("codebreaker".toLowerCase()+".dat"));
        int times = f.nextInt();
        f.nextLine();
        List<String> dictionary = new ArrayList<>();
        while(times-->0){

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new codebreaker().run();
    }
}
