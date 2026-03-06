import java.util.*;
import java.io.*;

public class five{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("five".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] arr=f.nextLine().split("");
            Arrays.sort(arr);
            for(String s : arr){
                System.out.print(s);
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new five().run();
    }
}
