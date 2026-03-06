import java.util.*;
import java.io.*;

public class education{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("education".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().split("\\s+");
            int sum = 0;
            for(String str: ln){
                sum+=Integer.parseInt(str);
            }
            System.out.println(sum);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new education().run();
    }
}
