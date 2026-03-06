import java.util.*;
import java.io.*;

public class zachary{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("zachary".toLowerCase()+".dat"));
        while(f.hasNext()){
            int a = f.nextInt();
            int b = f.nextInt();

            for (int i = 1; i <=a ; i++) {
                for (int j = 1; j <= b; j++){
                    System.out.print(i*j%10);
                }
                System.out.println();
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new zachary().run();
    }
}
