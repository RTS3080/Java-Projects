import java.util.*;
import java.io.*;

public class empire{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("empire".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n=f.nextInt();
            String planet = f.nextLine();
            String ln = f.nextLine();
            for (int i = 0; i < n; i++) {
                System.out.println(ln);
                System.out.println("The Empire Loves the Citizens of"+planet+"!");
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new empire().run();
    }
}
